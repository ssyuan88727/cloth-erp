package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 配送方式 (DeliveryMethods)
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryMethod implements Serializable {
  /**
   * 方式 ID (PK, Identity)
   * 
   */
  private Integer methodId;

  /**
   * 方式名稱
   * e.g., '7-11 店到店'
   */
  private String methodName;

  /**
   * 是否啟用
   * Default 1
   */
  private Boolean isActive;

  /**
   * 全域欄位: 建立時間
   * 
   */
  private LocalDateTime createdAt;

  /**
   * 全域欄位: 更新時間
   * 
   */
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
