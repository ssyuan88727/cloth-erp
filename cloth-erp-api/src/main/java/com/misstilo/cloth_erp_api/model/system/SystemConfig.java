package com.misstilo.cloth_erp_api.model.system;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系統設定表 (SystemConfigs)
 * 用於儲存不需頻繁更動的全域參數
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemConfig implements Serializable {

  /**
   * 設定鍵值 (PK)
   * e.g., 'ImgStoragePath', 'BackupStoragePath'
   */
  private String configKey;

  /**
   * 設定值
   * 支援長路徑字串 (NVARCHAR(MAX))
   */
  private String configValue;

  /**
   * 參數說明
   * 供維護者閱讀
   */
  private String description;

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
