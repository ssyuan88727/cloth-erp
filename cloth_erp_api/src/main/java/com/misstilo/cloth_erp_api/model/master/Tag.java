package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 標籤主檔 (Tags)
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag implements Serializable {
  /**
   * 標籤流水號 (PK, Identity)
   * 
   */
  private Integer tagId;

  /**
   * 標籤名稱
   * e.g., '熱銷', '裙子', '夏季新品'
   * Note: 需建立 Unique Index
   */
  private String tagName;

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
