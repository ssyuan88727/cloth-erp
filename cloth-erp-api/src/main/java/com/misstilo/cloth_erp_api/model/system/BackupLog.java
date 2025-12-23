package com.misstilo.cloth_erp_api.model.system;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 備份紀錄表 (BackupLogs)
 * 紀錄 SystemBackupService 的執行結果
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BackupLog implements Serializable {

  /**
   * 流水號 (PK, Identity)
   * 
   */
  private Integer logId;

  /**
   * 備份檔名
   * e.g., ERP_Backup_202512.bak
   */
  private String backupFileName;

  /**
   * 執行狀態
   * 1:'FAILED', 2:'SUCCESS', 3: 'SKIPPED'
   * 建議配合 Java Enum 使用
   */
  private Integer status;

  /**
   * 錯誤訊息
   * 若失敗，紀錄 Exception Message
   */
  private String message;

  /**
   * 執行時間
   * Default GETDATE()
   */
  private LocalDateTime executedAt;

  private static final long serialVersionUID = 1L;
}
