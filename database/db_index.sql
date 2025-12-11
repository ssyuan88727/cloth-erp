-- #######################################################################
-- # I. 基礎設定與字典檔 (Base Configuration & Dictionaries)
-- #######################################################################
-- Supplier (供應商主檔)
CREATE NONCLUSTERED INDEX NCIX_Supplier_Code_Name ON Supplier (Code, Name);
CREATE NONCLUSTERED INDEX NCIX_Supplier_Name_IsActive ON Supplier (Name, IsActive);
CREATE NONCLUSTERED INDEX NCIX_Supplier_CreateAt ON Supplier (CreateAt);
CREATE NONCLUSTERED INDEX NCIX_Supplier_UpdateAt ON Supplier (UpdateAt);