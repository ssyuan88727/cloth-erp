package com.misstilo.cloth_erp_api.model.inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 即時庫存 (Inventory)
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory implements Serializable {
  /**
   * SKU ID (PK, FK)
   * 1:1 對應 SKUs 表
   */
  private Integer skuId;

  /**
   * 目前庫存量
   * 允許負數 (若開啟負庫存功能)
   */
  private Integer quantity;

  /**
   * 加權平均成本
   * DECIMAL(18, 4)
   * Design: 使用 4 位小數避免運算誤差，顯示時再取整數
   */
  private BigDecimal avgCost;

  /**
   * 建立時間
   */
  private LocalDateTime createdAt;

  /**
   * 更新時間
   * Note: 每次異動都必須更新此欄位
   */
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
