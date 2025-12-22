package com.misstilo.cloth_erp_api.model.procurement;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 進貨單 (ReceivingNotes)
 * [cite: 213]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceivingNote implements Serializable {
  /**
   * 進貨單號 (PK)
   * [cite: 214] e.g., RI20251221001
   */
  private String riDocNo;

  /**
   * 來源採購單 (FK)
   * [cite: 215]
   */
  private String poDocNo;

  /**
   * 進貨/入庫日期
   * [cite: 216] Default GETDATE()
   */
  private LocalDate docDate;

  /**
   * 狀態
   * [cite: 217] 0:Draft, 1:Confirmed
   * 對應 Enum: ReceivingStatus
   */
  private Integer status;

  /**
   * 備註
   * [cite: 220] e.g., 外箱破損
   */
  private String note;

  /**
   * [cite: 36] 全域欄位
   */
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
