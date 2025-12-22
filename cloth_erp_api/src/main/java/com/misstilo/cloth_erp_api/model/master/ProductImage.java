package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 商品圖片 (ProductImages)
 * [cite: 90]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage implements Serializable {
  /**
   * 圖片流水號 (PK, Identity)
   * [cite: 91]
   */
  private Integer imageId;

  /**
   * 關聯商品 (FK)
   * [cite: 92] Delete Cascade 邏輯需在 Service 層或 DB FK 實作
   */
  private String productId;

  /**
   * 圖片實體檔名
   * [cite: 93] 僅存相對路徑 e.g. "P001_173478900.jpg"
   */
  private String filePath;

  /**
   * 排序 (1-8)
   * [cite: 94] 1 為主圖
   */
  private Integer sortOrder;

  // [cite: 53] 全域欄位 (注意：子表通常也建議保留建立時間)
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
