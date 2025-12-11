-- #######################################################################
-- # I. 基礎設定與字典檔 (Base Configuration & Dictionaries)
-- #######################################################################
-- Supplier (供應商主檔)
CREATE TABLE
    Supplier (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Code NVARCHAR (10) NOT NULL UNIQUE, -- 例如: S005
        Name NVARCHAR (20) NOT NULL, -- 供應商名稱
        ContactName NVARCHAR (20), -- 聯絡人姓名
        ContactPhone VARCHAR (20), -- 聯絡電話
        Address NVARCHAR(255), -- 地址
        IsActive BIT DEFAULT 1, -- 是否啟用
        CreateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
        UpdateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME ()
    );

-- StoreType (門市/倉庫類型字典表)
CREATE TABLE
    StoreType (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Name NVARCHAR (20) NOT NULL UNIQUE -- 例如: 門市, 倉庫
    );

-- Store (門市/倉庫主檔)
CREATE TABLE
    Store (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Code NVARCHAR (10) NOT NULL UNIQUE, -- 例如: S001
        Name NVARCHAR (20) NOT NULL, -- 門市/倉庫名稱
        StoreTypeId INT NOT NULL FOREIGN KEY REFERENCES StoreType (Id), -- 門市/倉庫類型
        IsActive BIT DEFAULT 1, -- 是否啟用
        CreateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
        UpdateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME ()
    );

-- ReturnReason (退回理由字典表 - 支援銷售與採購退回)
CREATE TABLE
    ReturnReason (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Reason NVARCHAR (10) NOT NULL -- 例如：尺碼不合, 商品瑕疵
    );

-- #######################################################################
-- # II. 商品與庫存模組 (Product & Inventory)
-- #######################################################################
-- Tag (標籤字典表 - 支援高效 M:N 關係)
CREATE TABLE
    Tag (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Name NVARCHAR (10) NOT NULL UNIQUE, -- 例如: 休閒, 棉麻, 夏季
    );

-- Color (顏色屬性字典表)
CREATE TABLE
    Color (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Code NVARCHAR (10) NOT NULL UNIQUE, -- 例如: RED
        Name NVARCHAR (20) NOT NULL -- 例如: 紅色
    );

-- Size (尺寸屬性字典表)
CREATE TABLE
    Size (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Code NVARCHAR (10) NOT NULL UNIQUE, -- 例如: M
        Name NVARCHAR (20) NOT NULL -- 例如: 中號
    );

-- Product (商品主檔)
CREATE TABLE
    Product (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Code VARCHAR (20) NOT NULL UNIQUE, -- 例如: P00101
        Name NVARCHAR (20) NOT NULL, -- 商品名稱
        Remark NVARCHAR (255), -- 商品描述
        UnitPrc DECIMAL(18, 2) NOT NULL, -- 建議售價
        IsActive BIT DEFAULT 1, -- 是否啟用
        CreateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
        UpdateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME ()
    );

-- ProductTagRel (商品-標籤關聯表)
CREATE TABLE
    ProductTagRel (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        ProductId INT NOT NULL FOREIGN KEY REFERENCES Product (Id), -- 商品ID
        TagId INT NOT NULL FOREIGN KEY REFERENCES Tag (Id), -- 標籤ID
        CONSTRAINT UQ_ProductTag UNIQUE (ProductId, TagId)
    );

-- ProductSku (商品 Sku 組合主檔)
CREATE TABLE
    ProductSku (
        Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY, -- 內部識別碼 (例如: P00101-SP001-RED-M)
        ProductId INT NOT NULL FOREIGN KEY REFERENCES Product (Id), -- 商品ID
        SupplierId INT FOREIGN KEY REFERENCES Supplier (Id), -- 預設供應商
        ColorId INT NOT NULL FOREIGN KEY REFERENCES Color (Id), -- 顏色屬性
        SizeId INT NOT NULL FOREIGN KEY REFERENCES Size (Id), -- 尺寸屬性
        SkuCode VARCHAR(30) NOT NULL, -- Sku 編號
        CostPrc DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 成本價
        IsActive BIT DEFAULT 1, -- Sku 是否啟用
        CONSTRAINT UQ_ProductSku UNIQUE (ProductId, SupplierId, ColorId, SizeId)
    );

-- Inventory (庫存主表)
CREATE TABLE
    Inventory (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        StoreId INT NOT NULL FOREIGN KEY REFERENCES Store (Id), -- 庫存所在門市/倉庫
        ProductSkuId INT NOT NULL FOREIGN KEY REFERENCES ProductSku (Id), -- Sku ID
        CurrentQty INT NOT NULL DEFAULT 0, -- 當前庫存數量
        PurchaseQty INT NOT NULL DEFAULT 0, -- 已採購數量
        PurchaseReturnQty INT NOT NULL DEFAULT 0, -- 已採購退回數量
        SaleQty INT NOT NULL DEFAULT 0, -- 訂單訂購數量
        SaleReturnQty INT NOT NULL DEFAULT 0, -- 訂單退貨數量
        ActualQty AS (
            CurrentQty - PurchaseQty - PurchaseReturnQty - SaleQty - SaleReturnQty
        ), -- 當前實際庫存數量
        CONSTRAINT UQ_Inventory_Sku_Store UNIQUE (StoreId, ProductSkuId)
    );

-- InventoryLogType (庫存異動類別字典表)
CREATE TABLE
    InventoryLogType (
        Id INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
        Name NVARCHAR(20) NOT NULL -- 庫存異動名稱
    );

-- InventoryLog (庫存異動表)
CREATE TABLE
    InventoryLog (
        Id INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
        InventoryLogTypeId INT NOT NULL FOREIGN KEY REFERENCES InventoryLogType (Id), -- 庫存異動代號
        StoreId INT NOT NULL FOREIGN KEY REFERENCES Store (Id), -- 店點 Id
        ProductSkuId INT NOT NULL FOREIGN KEY REFERENCES ProductSku (Id), -- 商品 Sku Id
        Qty INT NOT NULL DEFAULT 1, -- 異動數量
        BeforeQty INT NOT NULL DEFAULT 0, -- 異動前數量
        AfterQty AS (BeforeQty + Qty), -- 異動後數量
        CreateAt DATETIME2(3) NOT NULL DEFAULT SYSDATETIME(),
    );

-- #######################################################################
-- # III. 供應鏈與採購模組 (SCM & Purchasing)
-- #######################################################################
-- PurchaseOrder (採購訂單主表) - 簡化
CREATE TABLE
    PurchaseOrder (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Confirmed BIT NOT NULL DEFAULT 0, -- 是否已確認
        Signed BIT NOT NULL DEFAULT 0, -- 是否已簽核
        Code NVARCHAR (20) NOT NULL UNIQUE, -- 採購單號
        Date DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (), -- 訂單日期
        SupplierId INT NOT NULL FOREIGN KEY REFERENCES Supplier (Id), -- 供應商ID
        TotQty INT NOT NULL DEFAULT 0, -- 訂單總數量
        TotAmt DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 訂單總金額
        Remark NVARCHAR (255), -- 備註
        CreateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
        UpdateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME ()
    );

-- PurchaseOrderDetail (採購訂單明細)
CREATE TABLE
    PurchaseOrderDetail (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        PurchaseOrderId INT NOT NULL FOREIGN KEY REFERENCES PurchaseOrder (Id), -- 採購訂單ID
        ProductSkuId INT NOT NULL FOREIGN KEY REFERENCES ProductSku (Id), -- 採購 Sku ID
        PurchaseQty INT NOT NULL DEFAULT 1, -- 採購數量
        ReceivedQty INT NOT NULL DEFAULT 0, -- 已收貨數量
        UndeliveredQty AS (PurchaseQty - ReceivedQty), -- 尚欠數量
        CostPrc DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 單位成本
        SubTot AS (PurchaseQty * CostPrc), -- 小計
        CONSTRAINT UQ_PurchaseOrderDetail UNIQUE (PurchaseOrderId, ProductSkuId)
    );

-- PurchaseReceipt (採購收貨主表)
CREATE TABLE
    PurchaseReceipt (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Confirmed BIT NOT NULL DEFAULT 0, -- 是否已確認
        Signed BIT NOT NULL DEFAULT 0, -- 是否已簽核
        Code VARCHAR(20) NOT NULL UNIQUE, -- 採購收貨單號
        Date DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (), -- 收貨日期
        SupplierId INT NOT NULL FOREIGN KEY REFERENCES Supplier (Id), -- 供應商ID
        OriginalCode VARCHAR(20), -- 原始採購單號
        TotQty INT NOT NULL DEFAULT 0, -- 收貨總數量
        TotAmt DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 收貨總金額
        Remark NVARCHAR (255),
        CreateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
        UpdateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME ()
    );

-- PurchaseReceiptDetail (採購收貨明細)
CREATE TABLE
    PurchaseReceiptDetail (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        PurchaseReceiptId INT NOT NULL FOREIGN KEY REFERENCES PurchaseReceipt (Id), -- 採購收貨ID
        ProductSkuId INT NOT NULL FOREIGN KEY REFERENCES ProductSku (Id), -- 採購 Sku ID
        Qty INT NOT NULL DEFAULT 1, -- 收貨數量
        CostPrc DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 單位成本
        SubTot AS (Qty * CostPrc), -- 小計
        CONSTRAINT UQ_PurchaseReceiptDetail UNIQUE (PurchaseReceiptId, ProductSkuId)
    );

-- PurchaseReturn (採購退回/瑕疵處理表 - B2B 換貨/抵扣記錄)
CREATE TABLE
    PurchaseReturn (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Confirmed BIT NOT NULL DEFAULT 0, -- 是否已確認
        Signed BIT NOT NULL DEFAULT 0, -- 是否已簽核
        Code NVARCHAR (20) NOT NULL UNIQUE,
        Date DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (), -- 退回日期
        SupplierId INT NOT NULL FOREIGN KEY REFERENCES Supplier (Id), -- 供應商ID
        TotQty INT NOT NULL DEFAULT 0, -- 退回數量
        TotAmt DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 退回總金額
        Remark NVARCHAR (255),
        CreateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
        UpdateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
    );

-- PurchaseReturnDetail (採購退回明細表)
CREATE TABLE
    PurchaseReturnDetail (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        PurchaseReturnId INT NOT NULL FOREIGN KEY REFERENCES PurchaseReturn (Id), -- 採購退回ID
        ProductSkuId INT NOT NULL FOREIGN KEY REFERENCES ProductSku (Id), -- 退回 Sku ID
        ReturnReasonId INT NOT NULL FOREIGN KEY REFERENCES ReturnReason (Id), -- 退回理由 ID
        Qty INT NOT NULL DEFAULT 1, -- 退回數量
        CostPrc DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 單位成本
        SubTot AS (Qty * CostPrc), -- 小計
        CONSTRAINT UQ_PurchaseReturnDetail UNIQUE (PurchaseReturnId, ProductSkuId, ReturnReasonId)
    );

-- #######################################################################
-- # IV. 會員與 CRM 模組 (CRM)
-- #######################################################################
-- Member (會員主檔)
CREATE TABLE
    Member (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Code NVARCHAR (20) NOT NULL UNIQUE, -- 會員編號, 例如: M0001
        Name NVARCHAR (50) NOT NULL, -- 會員姓名
        Phone NVARCHAR (20), -- 聯絡電話
        Email NVARCHAR (100), -- 電子郵件
        Address NVARCHAR (255), -- 聯絡地址
        JoinDate DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (), -- 加入日期
        TotQty INT DEFAULT 0, -- 累積件數
        TotAmt DECIMAL(18, 2) DEFAULT 0, -- 1累積金額
        TotCnt INT DEFAULT 0, -- 累積次數
        IsActive BIT DEFAULT 1, -- 是否啟用
        CreateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
        UpdateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME ()
    );

-- #######################################################################
-- # V. 銷售與交易模組 (Sales & Transactions)
-- #######################################################################
-- SalesPlatform (銷售平台字典表)
CREATE TABLE
    SalesPlatform (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Name NVARCHAR (10) NOT NULL UNIQUE -- 例如: Shopee, MOMO
    );

-- PaymentMethod (付款方式字典表)
CREATE TABLE
    PaymentMethod (
        Id INT IDENTITY (1, 1) PRIMARY KEY, -- 付款方式ID
        Name NVARCHAR (10) NOT NULL UNIQUE -- 例如: 信用卡, 貨到付款
    );

-- SalesOrder (銷售訂單主表) - 線上/Shopee/MOMO
CREATE TABLE
    SalesOrder (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Code VARCHAR(20) NOT NULL UNIQUE, -- 訂單號
        Date DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (), -- 訂單日期
        MemberId INT FOREIGN KEY REFERENCES Member (Id), -- 會員ID
        StoreId INT NOT NULL FOREIGN KEY REFERENCES Store (Id), -- 銷售/出貨地點
        SalesPlatformId INT NOT NULL DEFAULT 0 FOREIGN KEY REFERENCES SalesPlatform (Id), -- 銷售平台, 0=線下, 1=Shopee, 2=MOMO
        TotAmt DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 訂單總金額
        DiscAmt DECIMAL(18, 2) NOT NUll DEFAULT 0, -- 折扣金額
        TaxAmt DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 稅金
        DeliveryFee DECIMAL(18, 2) DEFAULT 0, -- 配送費用
        PlatformFee DECIMAL(18, 2) DEFAULT 0, -- 電商平台手續費
        Status INT NOT NULL DEFAULT 0, -- 訂單狀態, 0=新訂單, 1=處理中, 2=已完成, 3=已取消
        PaymentMethodId INT NOT NULL DEFAULT 0 FOREIGN KEY REFERENCES PaymentMethod (Id), -- 付款方式, 0=貨到付款, 1=信用卡, 2=線上支付
        Remark NVARCHAR (255),
        CreateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
        UpdateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME ()
    );

-- SalesOrderDetail (銷售訂單明細)
CREATE TABLE
    SalesOrderDetail (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        SalesOrderId INT NOT NULL FOREIGN KEY REFERENCES SalesOrder (Id), -- 銷售訂單ID
        ProductSkuId INT NOT NULL FOREIGN KEY REFERENCES ProductSku (Id), -- Sku ID
        Qty INT NOT NULL DEFAULT 1, -- 銷售數量
        SellPrc DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 銷售單價
        DiscPrc DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 折扣金額
        SubTot AS ((SellPrc - DiscPrc) * Qty) PERSISTED, -- 小計金額
        CONSTRAINT UQ_SalesOrderDetail UNIQUE (SalesOrderId, ProductSkuId)
    );

-- SalesReturn (銷售退回主表 - B2C 退款記錄)
CREATE TABLE
    SalesReturn (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        Confirmed BIT NOT NULL DEFAULT 0, -- 是否已確認
        Signed BIT NOT NULL DEFAULT 0, -- 是否已簽核
        Code VARCHAR(20) NOT NULL UNIQUE, -- 退回單號
        Date DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (), -- 退單日期
        SalesOrderId INT NOT NULL FOREIGN KEY REFERENCES SalesOrder (Id), -- 來源銷售訂單ID
        ReturnReasonId INT NOT NULL FOREIGN KEY REFERENCES ReturnReason (Id), -- 退回理由
        TotQty INT NOT NULL DEFAULT 0, -- 退回數量
        TotAmt DECIMAL(18, 2) NOT NULL DEFAULT 0, -- 退款總金額
        Remark NVARCHAR (255), -- 備註
        CreateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME (),
        UpdateAt DATETIME2 (3) NOT NULL DEFAULT SYSDATETIME ()
    );

-- SalesReturnDetail (銷售退回明細表)
CREATE TABLE
    SalesReturnDetail (
        Id INT IDENTITY (1, 1) PRIMARY KEY,
        SalesReturnId INT NOT NULL FOREIGN KEY REFERENCES SalesReturn (Id), -- 銷售退回ID
        ProductSkuId INT NOT NULL FOREIGN KEY REFERENCES ProductSku (Id), -- 退回 Sku ID
        Qty INT NOT NULL DEFAULT 1, -- 退回數量
        RefundPrc DECIMAL(18, 2) NOT NULL, -- 退款金額
        SubTot AS (Qty * RefundPrc), -- 小計
        CONSTRAINT UQ_SalesReturnDetail UNIQUE (SalesReturnId, ProductSkuId)
    );