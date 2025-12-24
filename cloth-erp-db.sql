--========== 系統與設定 ==========
-- 系統參數
CREATE TABLE system_configs (
	id INT IDENTITY(1,1) PRIMARY KEY,
	cfg_key VARCHAR(50) NOT NULL UNIQUE,
	cfg_val VARCHAR(MAX) NOT NULL,
	descr NVARCHAR(200),
	created_at DATETIME2 DEFAULT SYSDATETIME(),
	updated_at DATETIME2
);

-- 備份日誌
CREATE TABLE backup_log (
	id INT IDENTITY(1,1) PRIMARY KEY,
	status BIT DEFAULT 0,
	file_name VARCHAR(255) NOT NULL UNIQUE,
	msg NVARCHAR(MAX),
	executed_at DATETIME2 DEFAULT SYSDATETIME()
);

-- 退回理由
CREATE TABLE return_reasons (
	id INT IDENTITY(1,1) PRIMARY KEY,
	rsn_text NVARCHAR(50),
	sort_order TINYINT DEFAULT 99,
	is_active BIT DEFAULT 1
);

-- 單據類別
CREATE TABLE doc_types (
	id INT IDENTITY(1,1) PRIMARY KEY,
	code VARCHAR(10) NOT NULL UNIQUE,
	name NVARCHAR(10)
);

-- 單據序號
CREATE TABLE doc_sequence (
	doc_type_id INT NOT NULL REFERENCES doc_types (id),
	date DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
	serial_no INT NOT NULL
);

-- 付款方式
CREATE TABLE payment_methods (
	id INT IDENTITY(1,1) PRIMARY KEY,
	name NVARCHAR(30) NOT NULL
);

-- ========== 主檔資料 ==========
-- 商品
CREATE TABLE products (
	id INT IDENTITY(1,1) PRIMARY KEY,
	code VARCHAR(50) NOT NULL UNIQUE,
	name NVARCHAR(100),
	is_active BIT DEFAULT 1,
	base_prc DECIMAL(19,4) DEFAULT 0,
	descr NVARCHAR(MAX),
	created_at DATETIME2 DEFAULT SYSDATETIME(),
	updated_at DATETIME2
);

-- 顏色
CREATE TABLE colors (
	id INT IDENTITY(1,1) PRIMARY KEY,
	code VARCHAR(20) NOT NULL UNIQUE,
	name NVARCHAR(20)
);

-- 尺寸
CREATE TABLE sizes (
	id INT IDENTITY(1,1) PRIMARY KEY,
	code VARCHAR(20) NOT NULL UNIQUE,
	name NVARCHAR(20)
);

-- 供應商
CREATE TABLE suppliers (
	id INT IDENTITY(1,1) PRIMARY KEY,
	code VARCHAR(20) NOT NULL UNIQUE,
	name NVARCHAR(50),
	is_active BIT DEFAULT 1,
	contact_person NVARCHAR(50),
	phone VARCHAR(50),
	addr NVARCHAR(255),
	note NVARCHAR(MAX),
	created_at DATETIME2 DEFAULT SYSDATETIME(),
	updated_at DATETIME2
);

-- 商品圖片
CREATE TABLE product_images (
	product_id INT NOT NULL REFERENCES products (id),
	file_name NVARCHAR(255) NOT NULL UNIQUE,
	sort_order TINYINT DEFAULT 99
);

-- 商品SKU
CREATE TABLE skus (
	id INT IDENTITY(1,1) PRIMARY KEY,
	code VARCHAR(255) NOT NULL UNIQUE,
	product_id INT REFERENCES products (id),
	supplier_id INT REFERENCES suppliers (id),
	color_id INT REFERENCES colors (id),
	size_id INT REFERENCES sizes (id),
	is_active BIT DEFAULT 0,
	pur_prc DECIMAL(19,4) DEFAULT 0,
);

-- 會員
CREATE TABLE members (
	id INT IDENTITY(1,1) PRIMARY KEY,
	code VARCHAR(50) NOT NULL UNIQUE,
	name NVARCHAR(50),
	is_active BIT DEFAULT 1,
	phone VARCHAR(30),
	addr NVARCHAR(255),
	total_spent DECIMAL(19,4) DEFAULT 0,
	last_pur_at DATETIME2,
	note NVARCHAR(255),
	created_at DATETIME2 DEFAULT SYSDATETIME(),
	updated_at DATETIME2
);