package com.misstilo.cloth_erp_api.model.system;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 退貨理由主檔 (ReturnReasons)
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnReason implements Serializable {

  /**
   * 理由 ID (PK, Identity)
   * 
   */
  private Integer reasonId;

  /**
   * 適用類型
   * Values: 'SO' (銷貨退回), 'PO' (採購退出), 'ALL' (通用)
   */
  private String reasonType;

  /**
   * 理由描述
   * e.g., '尺寸不合', '瑕疵品'
   */
  private String reasonText;

  /**
   * 排序權重
   * Default 99
   */
  private Integer sortOrder;

  /**
   * 是否啟用
   * Default 1
   */
  private Boolean isActive;

  /**
   * 全域欄位: 建立時間
   */
  private LocalDateTime createdAt;

  /**
   * 全域欄位: 更新時間
   */
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}