package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 供應商 (Suppliers)
 * [cite: 96]
 */
@Data
public class Supplier implements Serializable {
  /**
   * 供應商代號 (PK)
   * [cite: 98] NVARCHAR(20)
   */
  private String supplierId;

  private String supplierName;

  /**
   * 標準交貨天數
   * [cite: 100] Default 30
   */
  private Integer leadTime;

  /**
   * 最低訂購量
   * [cite: 101] Default 1
   */
  private Integer moq;

  private Boolean isActive;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
