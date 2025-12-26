--========== 系統與設定 ==========
-- 系統參數
CREATE TABLE
	system_configs (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		cfg_key VARCHAR(50) NOT NULL UNIQUE,
		cfg_val VARCHAR(MAX) NOT NULL,
		descr NVARCHAR (200),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 備份日誌
CREATE TABLE
	backup_log (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		status BIT DEFAULT 0,
		file_name VARCHAR(255) NOT NULL UNIQUE,
		msg NVARCHAR (MAX),
		executed_at DATETIME2 DEFAULT SYSDATETIME ()
	);

-- 退回理由
CREATE TABLE
	return_reasons (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		rsn_text NVARCHAR (50),
		sort_order TINYINT DEFAULT 99,
		is_active BIT DEFAULT 1
	);

-- 單據類別
CREATE TABLE
	doc_types (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		code VARCHAR(10) NOT NULL UNIQUE,
		name NVARCHAR (10)
	);

-- 單據序號
CREATE TABLE
	doc_sequence (
		doc_type_id INT NOT NULL REFERENCES doc_types (id),
		date DATETIME2 NOT NULL DEFAULT SYSDATETIME (),
		serial_no INT NOT NULL
	);

-- 付款方式
CREATE TABLE
	payment_methods (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		name NVARCHAR (30) NOT NULL
	);

-- ========== 主檔資料 ==========
-- 商品
CREATE TABLE
	products (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		code VARCHAR(50) NOT NULL UNIQUE,
		name NVARCHAR (100),
		is_active BIT DEFAULT 1,
		base_prc DECIMAL(19, 4) DEFAULT 0,
		descr NVARCHAR (MAX),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 顏色
CREATE TABLE
	colors (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		code VARCHAR(20) NOT NULL UNIQUE,
		name NVARCHAR (20)
	);

-- 尺寸
CREATE TABLE
	sizes (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		code VARCHAR(20) NOT NULL UNIQUE,
		name NVARCHAR (20)
	);

-- 標籤
CREATE TABLE
	tags (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		name NVARCHAR (50) NOT NULL UNIQUE,
		sort_order TINYINT DEFAULT 99
	);

-- 供應商
CREATE TABLE
	suppliers (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		code VARCHAR(20) NOT NULL UNIQUE,
		name NVARCHAR (50),
		is_active BIT DEFAULT 1,
		contact_person NVARCHAR (50),
		phone VARCHAR(50),
		addr NVARCHAR (255),
		note NVARCHAR (MAX),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 店鋪類別
CREATE TABLE
	store_types (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		name NVARCHAR (50) NOT NULL UNIQUE,
		sort_order TINYINT DEFAULT 99
	);

-- 店鋪
CREATE TABLE
	stores (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		name NVARCHAR (50) UNIQUE,
		store_type_id INT NOT NULL REFERENCES store_types (id),
		is_active BIT DEFAULT 1,
		addr NVARCHAR (255),
		phone VARCHAR(50),
		note NVARCHAR (MAX),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 商品圖片
CREATE TABLE
	product_images (
		product_id INT NOT NULL REFERENCES products (id),
		file_name NVARCHAR (255) NOT NULL UNIQUE,
		sort_order TINYINT DEFAULT 99
	);

-- 商品SKU
CREATE TABLE
	product_skus (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		code VARCHAR(255) NOT NULL UNIQUE,
		product_id INT REFERENCES products (id),
		supplier_id INT REFERENCES suppliers (id),
		color_id INT REFERENCES colors (id),
		size_id INT REFERENCES sizes (id),
		is_active BIT DEFAULT 0,
		pur_prc DECIMAL(19, 4) DEFAULT 0,
	);

-- 會員
CREATE TABLE
	members (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		code VARCHAR(50) NOT NULL UNIQUE,
		name NVARCHAR (50),
		is_active BIT DEFAULT 1,
		phone VARCHAR(30),
		addr NVARCHAR (255),
		total_spent DECIMAL(19, 4) DEFAULT 0,
		last_pur_at DATETIME2,
		note NVARCHAR (255),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 銷售通路
CREATE TABLE
	sale_channels (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		name NVARCHAR (50),
		fee_rate DECIMAL(3, 2) DEFAULT 0,
		ret_ship_fee DECIMAL(19, 4) DEFAULT 0,
		sort_order TINYINT DEFAULT 99
	);

-- 配送方式
CREATE TABLE
	delivery_methods (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		name NVARCHAR (50),
		sort_order TINYINT DEFAULT 99
	);

-- 商品標籤關聯
CREATE TABLE
	product_tags (
		product_id INT NOT NULL REFERENCES products (id),
		tag_id INT NOT NULL REFERENCES tags (id),
		CONSTRAINT PK_product_tags PRIMARY KEY (product_id, tag_id)
	);

-- ========== 庫存核心 ==========
-- 即時庫存
CREATE TABLE
	current_stock (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		store_id INT NOT NULL REFERENCES stores (id),
		sku_id INT NOT NULL REFERENCES product_skus (id),
		qty INT DEFAULT 0,
		avg_cost DECIMAL(19, 4) DEFAULT 0,
		updated_at DATETIME2 DEFAULT SYSDATETIME (),
		CONSTRAINT UQ_store_sku UNIQUE (store_id, sku_id)
	);

-- 庫存流水帳
CREATE TABLE
	stock_logs (
		store_id INT NOT NULL REFERENCES stores (id),
		doc_type_id INT NOT NULL REFERENCES doc_types (id),
		src_doc_no VARCHAR(50) NOT NULL,
		ref_detail_id INT,
		sku_id INT NOT NULL REFERENCES product_skus (id),
		before_qty INT DEFAULT 0,
		qty_chg INT DEFAULT 0,
		after_qty INT DEFAULT 0,
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		CONSTRAINT UQ_store_sku UNIQUE (store_id, sku_id)
	);

-- ========== 廠商單據 ==========
-- 採購單
CREATE TABLE
	purchase_heads (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		doc_type_id INT NOT NULL DEFAULT 0 REFERENCES doc_types (id),
		doc_no VARCHAR(50) NOT NULL UNIQUE,
		doc_date DATETIME2 NOT NULL DEFAULT SYSDATETIME (),
		status TINYINT DEFAULT 0,
		store_id INT NOT NULL REFERENCES stores (id),
		supplier_id INT NOT NULL REFERENCES suppliers (id),
		note NVARCHAR (MAX),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 採購明細
CREATE TABLE
	purchase_items (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		pur_id INT NOT NULL REFERENCES purchase_heads (id),
		sku_id INT NOT NULL REFERENCES product_skus (id),
		qty INT DEFAULT 0,
		unit_prc DECIMAL(19, 4) DEFAULT 0,
		sub_tot AS qty * unit_prc,
		rcv_qty INT DEFAULT 0,
		CONSTRAINT UQ_pur_sku UNIQUE (pur_id, sku_id)
	);

-- 進貨單
CREATE TABLE
	receipt_heads (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		doc_type_id INT NOT NULL DEFAULT 1 REFERENCES doc_types (id),
		doc_no VARCHAR(50) NOT NULL UNIQUE,
		doc_date DATETIME2 NOT NULL DEFAULT SYSDATETIME (),
		status TINYINT DEFAULT 0,
		store_id INT NOT NULL REFERENCES stores (id),
		supplier_id INT NOT NULL REFERENCES suppliers (id),
		note NVARCHAR (MAX),
		create_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 進貨明細
CREATE TABLE
	receipt_items (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		receipt_id INT NOT NULL REFERENCES receipt_heads (id),
		sku_id INT NOT NULL REFERENCES product_skus (id),
		qty INT DEFAULT 0,
		unit_prc DECIMAL(19, 4) DEFAULT 0,
		sub_tot AS qty * unit_prc,
		CONSTRAINT UQ_receipt_sku UNIQUE (receipt_id, sku_id)
	);

-- 退貨單
CREATE TABLE
	purchase_return_heads (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		doc_type_id INT NOT NULL DEFAULT 2 REFERENCES doc_types (id),
		doc_no VARCHAR(50) NOT NULL UNIQUE,
		doc_date DATETIME2 NOT NULL DEFAULT SYSDATETIME (),
		status TINYINT DEFAULT 0,
		store_id INT NOT NULL REFERENCES stores (id),
		supplier_id INT NOT NULL REFERENCES suppliers (id),
		src_doc_no VARCHAR(50),
		note NVARCHAR (MAX),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 退貨明細
CREATE TABLE
	purchase_return_item (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		prt_id INT NOT NULL REFERENCES purchase_return_heads (id),
		sku_id INT NOT NULL REFERENCES product_skus (id),
		return_reason_id INT REFERENCES return_reasons (id),
		qty INT DEFAULT 0,
		unit_prc DECIMAL(19, 4) DEFAULT 0,
		sub_tot AS qty * unit_prc,
		CONSTRAINT UQ_prt_sku UNIQUE (prt_id, sku_id)
	);

-- ========== 銷貨單據 ==========
-- 銷貨單
CREATE TABLE
	sale_heads (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		doc_type_id INT NOT NULL DEFAULT 3 REFERENCES doc_types (id),
		doc_no VARCHAR(50) NOT NULL UNIQUE,
		doc_date DATETIME2 NOT NULL DEFAULT SYSDATETIME (),
		status TINYINT DEFAULT 0,
		store_id INT NOT NULL REFERENCES stores (id),
		sales_channel_id INT REFERENCES sales_channels (id),
		member_id INT REFERENCES members (id),
		delivery_method_id INT REFERENCES delivery_methods (id),
		addr NVARCHAR (255),
		ship_fee DECIMAL(19, 4) DEFAULT 0,
		tot_qty INT DEFAULT 0,
		tot_amt DECIMAL(19, 4) DEFAULT 0,
		channel_fee DECIMAL(19, 4) DEFAULT 0,
		pm_id INT REFERENCES payment_methods (id),
		note NVARCHAR (MAX),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 銷貨明細
CREATE TABLE
	sale_items (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		sal_id INT NOT NULL REFERENCES sale_heads (id),
		sku_id INT NOT NULL REFERENCES product_skus (id),
		unit_prc DECIMAL(19, 4) DEFAULT 0,
		qty INT DEFAULT 0,
		sub_tot AS qty * unit_prc,
		discount DECIMAL(19, 4) DEFAULT 0,
		CONSTRAINT UQ_sal_sku UNIQUE (sal_id, sku_id)
	);

-- 銷貨退回單
CREATE TABLE
	sale_return_heads (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		doc_type_id INT NOT NULL DEFAULT 4 REFERENCES doc_types (id),
		doc_no VARCHAR(50) NOT NULL UNIQUE,
		doc_date DATETIME2 NOT NULL DEFAULT SYSDATETIME (),
		status TINYINT DEFAULT 0,
		store_id INT NOT NULL REFERENCES stores (id),
		src_doc_no VARCHAR(50),
		ship_fee DECIMAL(19, 4) DEFAULT 0,
		tot_qty INT DEFAULT 0,
		tot_amt DECIMAL(19, 4) DEFAULT 0,
		note NVARCHAR (MAX),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 銷貨退回明細
CREATE TABLE
	sale_return_items (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		sal_ret_id INT NOT NULL REFERENCES sale_return_heads (id),
		sku_id INT NOT NULL REFERENCES product_skus (id),
		return_reason_id INT REFERENCES return_reasons (id),
		unit_prc DECIMAL(19, 4) DEFAULT 0,
		qty INT DEFAULT 0,
		sub_tot AS qty * unit_prc,
		discount DECIMAL(19, 4) DEFAULT 0,
		CONSTRAINT UQ_ret_sku UNIQUE (sal_ret_id, sku_id)
	);

-- ========== 庫存盤點與調整 ==========
-- 盤點單
CREATE TABLE
	stock_take_heads (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		doc_type_id INT NOT NULL DEFAULT 5 REFERENCES doc_types (id),
		doc_no VARCHAR(50) NOT NULL UNIQUE,
		doc_date DATETIME2 NOT NULL DEFAULT SYSDATETIME (),
		status TINYINT DEFAULT 0,
		store_id INT NOT NULL REFERENCES stores (id),
		note NVARCHAR (MAX),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 盤點明細
CREATE TABLE
	stock_take_items (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		stk_id INT NOT NULL REFERENCES stock_take_heads (id),
		sku_id INT NOT NULL REFERENCES product_skus (id),
		sys_qty INT DEFAULT 0,
		qty INT DEFAULT 0,
		diff_qty AS sys_qty - qty,
		CONSTRAINT UQ_stk_sku UNIQUE (stk_id, sku_id)
	);

-- 調整單
CREATE TABLE
	adjustment_heads (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		doc_type_id INT NOT NULL DEFAULT 6 REFERENCES doc_types (id),
		doc_no VARCHAR(50) NOT NULL UNIQUE,
		doc_date DATETIME2 NOT NULL DEFAULT SYSDATETIME (),
		status TINYINT DEFAULT 0,
		store_id INT NOT NULL REFERENCES stores (id),
		src_doc_no VARCHAR(50),
		note NVARCHAR (MAX),
		created_at DATETIME2 DEFAULT SYSDATETIME (),
		updated_at DATETIME2
	);

-- 調整明細
CREATE TABLE
	adjustment_items (
		id INT IDENTITY (1, 1) PRIMARY KEY,
		adj_id INT NOT NULL REFERENCES adjustment_heads (id),
		sku_id INT NOT NULL REFERENCES product_skus (id),
		qty INT DEFAULT 0,
		CONSTRAINT UQ_adj_sku UNIQUE (adj_id, sku_id)
	);