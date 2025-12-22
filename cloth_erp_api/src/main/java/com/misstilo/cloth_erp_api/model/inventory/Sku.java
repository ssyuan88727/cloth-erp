package com.misstilo.cloth_erp_api.model.inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 庫存單元 (SKUs)
 * 系統核心 ID，所有進銷存單據皆參照此 ID
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sku implements Serializable {
  /**
   * 系統內部流水號 (PK, Identity)
   * 
   */
  private Integer skuId;

  /**
   * 組合編碼字串
   * e.g., 'P001-RED-XL'
   * Validation: ^[A-Za-z0-9\-]+$
   */
  private String skuCode;

  /**
   * 關聯商品 (FK)
   * 
   */
  private String productId;

  /**
   * 關聯供應商 (FK)
   * 
   */
  private String supplierId;

  /**
   * 關聯顏色 (FK)
   * 
   */
  private Integer colorId;

  /**
   * 關聯尺寸 (FK)
   * 
   */
  private Integer sizeId;

  /**
   * 預設進貨成本
   * DECIMAL(18,0)
   * Note: 修改時需觸發 Service 更新 Draft 狀態 PO 的單價
   */
  private BigDecimal purchasePrice;

  /**
   * 安全庫存量
   * Default 0
   */
  private Integer safetyStock;

  /**
   * 是否啟用
   * Default 1
   */
  private Boolean isActive;

  /**
   * 全域欄位
   */
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
