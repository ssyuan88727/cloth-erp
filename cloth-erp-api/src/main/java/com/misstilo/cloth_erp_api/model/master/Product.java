package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 商品主檔 (Products)
 * [cite: 84]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
  /**
   * 商品代號 (PK)
   * NVARCHAR(50), e.g., "P001"
   */
  private String productId;

  /**
   * 商品名稱
   * [cite: 86]
   */
  private String productName;

  /**
   * 目前標準售價
   * [cite: 87] DECIMAL(18, 0)
   * 建議使用 BigDecimal 即使是整數，以保留運算擴充性
   */
  private BigDecimal basePrice;

  /**
   * 商品描述
   * [cite: 88] NVARCHAR(MAX)
   */
  private String description;

  /**
   * 是否啟用
   * [cite: 89] Default 1
   */
  private Boolean isActive;

  // [cite: 53] 全域欄位
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
