/*
 * Database Schema for Apparel ERP System (Latest Spec)
 * Source File: 服飾業進銷存系統規格書.pdf
 * DBMS: Microsoft SQL Server
 * Collation: Chinese_Taiwan_Stroke_CI_AS
 */

-- =============================================
-- 1. 系統配置與備份 (System Configuration)
-- =============================================

-- Table: SystemConfigs [Source: 70]
CREATE TABLE [dbo].[SystemConfigs] (
    [ConfigKey] NVARCHAR(50) NOT NULL,
    [ConfigValue] NVARCHAR(MAX) NOT NULL,
    [Description] NVARCHAR(200) NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_SystemConfigs] PRIMARY KEY CLUSTERED ([ConfigKey])
);

-- Table: BackupLogs [Source: 76]
CREATE TABLE [dbo].[BackupLogs] (
    [LogID] INT IDENTITY(1,1) NOT NULL,
    [BackupFileName] NVARCHAR(255) NULL,
    [Status] INT NOT NULL, -- 1:FAILED, 2:SUCCESS, 3:SKIPPED
    [Message] NVARCHAR(MAX) NULL,
    [ExecutedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    CONSTRAINT [PK_BackupLogs] PRIMARY KEY CLUSTERED ([LogID])
);

-- Table: ReturnReasons [Source: 84]
CREATE TABLE [dbo].[ReturnReasons] (
    [ReasonID] INT IDENTITY(1,1) NOT NULL,
    [ReasonType] VARCHAR(10) NOT NULL, -- 'SO', 'PO', 'ALL'
    [ReasonText] NVARCHAR(50) NOT NULL,
    [SortOrder] INT DEFAULT 99 NOT NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_ReturnReasons] PRIMARY KEY CLUSTERED ([ReasonID])
);

-- =============================================
-- 2. 主檔資料 (Master Data)
-- =============================================

-- Table: Suppliers [Source: 106]
CREATE TABLE [dbo].[Suppliers] (
    [SupplierID] NVARCHAR(20) NOT NULL,
    [SupplierName] NVARCHAR(100) NOT NULL,
    [LeadTime] INT DEFAULT 30 NOT NULL,
    [MOQ] INT DEFAULT 1 NOT NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_Suppliers] PRIMARY KEY CLUSTERED ([SupplierID])
);

-- Table: SalesChannels [Source: 113]
CREATE TABLE [dbo].[SalesChannels] (
    [ChannelID] INT IDENTITY(1,1) NOT NULL,
    [ChannelName] NVARCHAR(50) NOT NULL,
    [FeeRate] DECIMAL(5, 4) DEFAULT 0.0000 NOT NULL, -- 4 decimal places for rates (e.g., 0.0550)
    [ReturnShippingFee] DECIMAL(18, 0) DEFAULT 0 NOT NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_SalesChannels] PRIMARY KEY CLUSTERED ([ChannelID])
);

-- Table: DeliveryMethods [Source: 123]
CREATE TABLE [dbo].[DeliveryMethods] (
    [MethodID] INT IDENTITY(1,1) NOT NULL,
    [MethodName] NVARCHAR(50) NOT NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_DeliveryMethods] PRIMARY KEY CLUSTERED ([MethodID])
);

-- Table: Members [Source: 127]
CREATE TABLE [dbo].[Members] (
    [MemberID] INT IDENTITY(1,1) NOT NULL,
    [MemberCode] VARCHAR(30) NOT NULL,
    [Name] NVARCHAR(50) NOT NULL,
    [Phone] VARCHAR(20) NOT NULL,
    [Address] NVARCHAR(255) NULL,
    [Note] NVARCHAR(MAX) NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_Members] PRIMARY KEY CLUSTERED ([MemberID])
);
CREATE UNIQUE NONCLUSTERED INDEX [IX_Members_MemberCode] ON [dbo].[Members] ([MemberCode]);
CREATE UNIQUE NONCLUSTERED INDEX [IX_Members_Phone] ON [dbo].[Members] ([Phone]);

-- Table: Colors [Source: 139]
CREATE TABLE [dbo].[Colors] (
    [ColorID] INT IDENTITY(1,1) NOT NULL,
    [ColorName] NVARCHAR(20) NOT NULL,
    [ColorCode] NVARCHAR(10) NOT NULL, -- Uppercase alphanumeric
    [SortOrder] INT DEFAULT 99 NOT NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_Colors] PRIMARY KEY CLUSTERED ([ColorID])
);

-- Table: Sizes [Source: 149]
CREATE TABLE [dbo].[Sizes] (
    [SizeID] INT IDENTITY(1,1) NOT NULL,
    [SizeName] NVARCHAR(20) NOT NULL,
    [SizeCode] NVARCHAR(10) NOT NULL,
    [SortOrder] INT DEFAULT 99 NOT NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_Sizes] PRIMARY KEY CLUSTERED ([SizeID])
);

-- Table: Tags [Source: 157]
CREATE TABLE [dbo].[Tags] (
    [TagID] INT IDENTITY(1,1) NOT NULL,
    [TagName] NVARCHAR(50) NOT NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_Tags] PRIMARY KEY CLUSTERED ([TagID])
);
CREATE UNIQUE NONCLUSTERED INDEX [IX_Tags_TagName] ON [dbo].[Tags] ([TagName]);

-- Table: Products [Source: 93]
CREATE TABLE [dbo].[Products] (
    [ProductID] NVARCHAR(50) NOT NULL,
    [ProductName] NVARCHAR(100) NOT NULL,
    [BasePrice] DECIMAL(18, 0) NOT NULL,
    [Description] NVARCHAR(MAX) NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED ([ProductID])
);

-- Table: ProductImages [Source: 99]
CREATE TABLE [dbo].[ProductImages] (
    [ImageID] INT IDENTITY(1,1) NOT NULL,
    [ProductID] NVARCHAR(50) NOT NULL,
    [FilePath] NVARCHAR(255) NOT NULL, -- Relative path
    [SortOrder] INT NOT NULL,
    CONSTRAINT [PK_ProductImages] PRIMARY KEY CLUSTERED ([ImageID]),
    CONSTRAINT [FK_ProductImages_Products] FOREIGN KEY ([ProductID]) 
        REFERENCES [dbo].[Products] ([ProductID]) ON DELETE CASCADE
);

-- Table: ProductTags [Source: 163]
CREATE TABLE [dbo].[ProductTags] (
    [ProductID] NVARCHAR(50) NOT NULL,
    [TagID] INT NOT NULL,
    CONSTRAINT [PK_ProductTags] PRIMARY KEY CLUSTERED ([ProductID], [TagID]),
    CONSTRAINT [FK_ProductTags_Products] FOREIGN KEY ([ProductID]) REFERENCES [dbo].[Products] ([ProductID]),
    CONSTRAINT [FK_ProductTags_Tags] FOREIGN KEY ([TagID]) REFERENCES [dbo].[Tags] ([TagID])
);
CREATE NONCLUSTERED INDEX [IX_ProductTags_TagID] ON [dbo].[ProductTags] ([TagID]);

-- =============================================
-- 3. 庫存核心 (Inventory Core)
-- =============================================

-- Table: SKUs [Source: 172]
CREATE TABLE [dbo].[SKUs] (
    [SkuID] INT IDENTITY(1,1) NOT NULL,
    [SkuCode] VARCHAR(100) NOT NULL, -- Composition: Product-Color-Size
    [ProductID] NVARCHAR(50) NOT NULL,
    [SupplierID] NVARCHAR(20) NULL,
    [ColorID] INT NOT NULL,
    [SizeID] INT NOT NULL,
    [PurchasePrice] DECIMAL(18, 0) NOT NULL,
    [IsActive] BIT DEFAULT 1 NOT NULL,
    [SafetyStock] INT DEFAULT 0 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_SKUs] PRIMARY KEY CLUSTERED ([SkuID]),
    CONSTRAINT [FK_SKUs_Products] FOREIGN KEY ([ProductID]) REFERENCES [dbo].[Products] ([ProductID]),
    CONSTRAINT [FK_SKUs_Suppliers] FOREIGN KEY ([SupplierID]) REFERENCES [dbo].[Suppliers] ([SupplierID]),
    CONSTRAINT [FK_SKUs_Colors] FOREIGN KEY ([ColorID]) REFERENCES [dbo].[Colors] ([ColorID]),
    CONSTRAINT [FK_SKUs_Sizes] FOREIGN KEY ([SizeID]) REFERENCES [dbo].[Sizes] ([SizeID])
);
CREATE UNIQUE NONCLUSTERED INDEX [IX_SKUs_SkuCode] ON [dbo].[SKUs] ([SkuCode]);

-- Table: Inventory [Source: 190]
CREATE TABLE [dbo].[Inventory] (
    [SkuID] INT NOT NULL,
    [Quantity] INT DEFAULT 0 NOT NULL,
    [AvgCost] DECIMAL(18, 4) DEFAULT 0 NOT NULL, -- 4 decimal places
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_Inventory] PRIMARY KEY CLUSTERED ([SkuID]),
    CONSTRAINT [FK_Inventory_SKUs] FOREIGN KEY ([SkuID]) REFERENCES [dbo].[SKUs] ([SkuID])
);

-- Table: StockTransactionLogs [Source: 201]
CREATE TABLE [dbo].[StockTransactionLogs] (
    [LogID] INT IDENTITY(1,1) NOT NULL,
    [DocType] TINYINT NOT NULL, -- 1:PO_IN, 2:PO_RET, 3:SO_OUT, 4:SO_RET, 5:ADJ
    [DocNo] NVARCHAR(50) NOT NULL,
    [RefDetailID] INT NULL,
    [SkuID] INT NOT NULL,
    [QtyChange] INT NOT NULL,
    [CostBefore] DECIMAL(18, 4) NULL,
    [CostAfter] DECIMAL(18, 4) NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    CONSTRAINT [PK_StockTransactionLogs] PRIMARY KEY CLUSTERED ([LogID]),
    CONSTRAINT [FK_StockLogs_SKUs] FOREIGN KEY ([SkuID]) REFERENCES [dbo].[SKUs] ([SkuID])
);

-- =============================================
-- 4. 採購與進貨 (Procurement)
-- =============================================

-- Table: PurchaseOrders [Source: 222]
CREATE TABLE [dbo].[PurchaseOrders] (
    [DocNo] NVARCHAR(50) NOT NULL,
    [DocDate] DATE NOT NULL,
    [Status] TINYINT NOT NULL, -- 0:Draft, 1:Confirmed, 2:Closed, 3:ForceClosed
    [ExternalDocNo] NVARCHAR(100) NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_PurchaseOrders] PRIMARY KEY CLUSTERED ([DocNo])
);

-- Table: PODetails [Source: 234]
CREATE TABLE [dbo].[PODetails] (
    [DetailID] INT IDENTITY(1,1) NOT NULL,
    [DocNo] NVARCHAR(50) NOT NULL,
    [SkuID] INT NOT NULL,
    [UnitPrice] DECIMAL(18, 0) NOT NULL,
    [OrderQty] INT NOT NULL,
    [ReceivedQty] INT DEFAULT 0 NULL,
    CONSTRAINT [PK_PODetails] PRIMARY KEY CLUSTERED ([DetailID]),
    CONSTRAINT [FK_PODetails_PO] FOREIGN KEY ([DocNo]) REFERENCES [dbo].[PurchaseOrders] ([DocNo]),
    CONSTRAINT [FK_PODetails_SKUs] FOREIGN KEY ([SkuID]) REFERENCES [dbo].[SKUs] ([SkuID])
);

-- Table: ReceivingNotes [Source: 247]
CREATE TABLE [dbo].[ReceivingNotes] (
    [RIDocNo] NVARCHAR(50) NOT NULL,
    [PODocNo] NVARCHAR(50) NOT NULL,
    [DocDate] DATE DEFAULT GETDATE() NOT NULL,
    [Status] TINYINT NOT NULL, -- 0:Draft, 1:Confirmed
    [Note] NVARCHAR(200) NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_ReceivingNotes] PRIMARY KEY CLUSTERED ([RIDocNo]),
    CONSTRAINT [FK_ReceivingNotes_PO] FOREIGN KEY ([PODocNo]) REFERENCES [dbo].[PurchaseOrders] ([DocNo])
);

-- Table: RIDetails [Source: 255]
CREATE TABLE [dbo].[RIDetails] (
    [DetailID] INT IDENTITY(1,1) NOT NULL,
    [RIDocNo] NVARCHAR(50) NOT NULL,
    [SkuID] INT NOT NULL,
    [Qty] INT NOT NULL,
    CONSTRAINT [PK_RIDetails] PRIMARY KEY CLUSTERED ([DetailID]),
    CONSTRAINT [FK_RIDetails_RN] FOREIGN KEY ([RIDocNo]) REFERENCES [dbo].[ReceivingNotes] ([RIDocNo]),
    CONSTRAINT [FK_RIDetails_SKUs] FOREIGN KEY ([SkuID]) REFERENCES [dbo].[SKUs] ([SkuID])
);

-- =============================================
-- 5. 銷貨與退貨 (Sales & Returns)
-- =============================================

-- Table: SalesOrders [Source: 283]
CREATE TABLE [dbo].[SalesOrders] (
    [DocNo] NVARCHAR(50) NOT NULL,
    [DocDate] DATETIME2 NOT NULL,
    [MemberID] INT NOT NULL,
    [ChannelID] INT NOT NULL,
    [DeliveryMethodID] INT NOT NULL,
    [TrackingNo] NVARCHAR(50) NULL,
    [ExternalDocNo] NVARCHAR(100) NULL,
    [PlatformFee] DECIMAL(18, 0) DEFAULT 0 NULL,
    [PaymentStatus] BIT DEFAULT 0 NULL, -- 0:Unpaid, 1:Paid
    [ReconciliationStatus] BIT DEFAULT 0 NULL, -- 0:Unreconciled, 1:Reconciled
    [PaidAmount] DECIMAL(18, 0) DEFAULT 0 NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_SalesOrders] PRIMARY KEY CLUSTERED ([DocNo]),
    CONSTRAINT [FK_SalesOrders_Members] FOREIGN KEY ([MemberID]) REFERENCES [dbo].[Members] ([MemberID]),
    CONSTRAINT [FK_SalesOrders_Channels] FOREIGN KEY ([ChannelID]) REFERENCES [dbo].[SalesChannels] ([ChannelID]),
    CONSTRAINT [FK_SalesOrders_Delivery] FOREIGN KEY ([DeliveryMethodID]) REFERENCES [dbo].[DeliveryMethods] ([MethodID])
);

-- Table: SODetails [Source: 303]
CREATE TABLE [dbo].[SODetails] (
    [DetailID] INT IDENTITY(1,1) NOT NULL,
    [DocNo] NVARCHAR(50) NOT NULL,
    [SkuID] INT NOT NULL,
    [Qty] INT NOT NULL,
    [UnitPrice] DECIMAL(18, 0) NOT NULL, -- Snapshot
    [CostAtMoment] DECIMAL(18, 4) NOT NULL, -- Snapshot of AvgCost
    CONSTRAINT [PK_SODetails] PRIMARY KEY CLUSTERED ([DetailID]),
    CONSTRAINT [FK_SODetails_SO] FOREIGN KEY ([DocNo]) REFERENCES [dbo].[SalesOrders] ([DocNo]),
    CONSTRAINT [FK_SODetails_SKUs] FOREIGN KEY ([SkuID]) REFERENCES [dbo].[SKUs] ([SkuID])
);

-- Table: SalesReturns [Source: 312]
CREATE TABLE [dbo].[SalesReturns] (
    [ReturnDocNo] NVARCHAR(50) NOT NULL,
    [ReturnDate] DATETIME2 DEFAULT GETDATE() NULL,
    [OriginalSODetailID] INT NOT NULL,
    [Qty] INT NOT NULL,
    [ReasonID] INT NOT NULL,
    [RefundType] TINYINT DEFAULT 1 NULL, -- 1:CASH, 2:CREDIT
    [IsRefunded] BIT DEFAULT 0 NULL, -- 0:Pending, 1:Refunded
    [ReturnShippingFee] DECIMAL(18, 0) DEFAULT 0 NULL,
    [RefundedFee] DECIMAL(18, 0) DEFAULT 0 NULL, -- Platform fee returned
    [ReconciliationStatus] BIT DEFAULT 0 NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_SalesReturns] PRIMARY KEY CLUSTERED ([ReturnDocNo]),
    CONSTRAINT [FK_SalesReturns_SODetails] FOREIGN KEY ([OriginalSODetailID]) REFERENCES [dbo].[SODetails] ([DetailID]),
    CONSTRAINT [FK_SalesReturns_Reasons] FOREIGN KEY ([ReasonID]) REFERENCES [dbo].[ReturnReasons] ([ReasonID])
);

-- =============================================
-- 6. 庫存盤點與調整 (Inventory Count & Adjustment)
-- =============================================

-- Table: StockTakingNotes [Source: 340]
CREATE TABLE [dbo].[StockTakingNotes] (
    [DocNo] NVARCHAR(50) NOT NULL,
    [DocDate] DATE DEFAULT GETDATE() NULL,
    [Status] TINYINT NULL, -- 0:Draft, 1:Counted, 2:Approved, 3:Void
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_StockTakingNotes] PRIMARY KEY CLUSTERED ([DocNo])
);

-- Table: StockTakingDetails [Source: 349]
CREATE TABLE [dbo].[StockTakingDetails] (
    [DetailID] INT IDENTITY(1,1) NOT NULL,
    [DocNo] NVARCHAR(50) NOT NULL,
    [SkuID] INT NOT NULL,
    [SystemQty] INT NOT NULL, -- Snapshot
    [CountQty] INT NOT NULL, -- Actual count
    [DiffQty] AS ([CountQty] - [SystemQty]), -- Computed Column
    CONSTRAINT [PK_StockTakingDetails] PRIMARY KEY CLUSTERED ([DetailID]),
    CONSTRAINT [FK_StockTakingDetails_Note] FOREIGN KEY ([DocNo]) REFERENCES [dbo].[StockTakingNotes] ([DocNo]),
    CONSTRAINT [FK_StockTakingDetails_SKUs] FOREIGN KEY ([SkuID]) REFERENCES [dbo].[SKUs] ([SkuID])
);

-- Table: AdjustmentNotes [Source: 357]
CREATE TABLE [dbo].[AdjustmentNotes] (
    [AdjDocNo] NVARCHAR(50) NOT NULL,
    [SourceDocNo] NVARCHAR(50) NULL, -- Optional Link to StockTakingNotes
    [Reason] NVARCHAR(200) NULL,
    [AdjDate] DATETIME2 NOT NULL,
    [CreatedAt] DATETIME2 DEFAULT GETDATE() NOT NULL,
    [UpdatedAt] DATETIME2 NULL,
    CONSTRAINT [PK_AdjustmentNotes] PRIMARY KEY CLUSTERED ([AdjDocNo])
);

-- Table: AdjustmentDetails [Source: 361]
CREATE TABLE [dbo].[AdjustmentDetails] (
    [DetailID] INT IDENTITY(1,1) NOT NULL,
    [AdjDocNo] NVARCHAR(50) NOT NULL,
    [SkuID] INT NOT NULL,
    [AdjQty] INT NOT NULL, -- Positive or Negative
    [CostAtMoment] DECIMAL(18, 4) NULL,
    CONSTRAINT [PK_AdjustmentDetails] PRIMARY KEY CLUSTERED ([DetailID]),
    CONSTRAINT [FK_AdjustmentDetails_Note] FOREIGN KEY ([AdjDocNo]) REFERENCES [dbo].[AdjustmentNotes] ([AdjDocNo]),
    CONSTRAINT [FK_AdjustmentDetails_SKUs] FOREIGN KEY ([SkuID]) REFERENCES [dbo].[SKUs] ([SkuID])
);