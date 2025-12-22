package com.misstilo.cloth_erp_api.model.count;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 盤點單 (StockTakingNotes)
 * [cite: 292]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockTakingNote implements Serializable {
  /**
   * 盤點單號 (PK)
   * e.g., ST2025...
   */
  private String docNo;

  /**
   * 盤點日期
   * [cite: 294] Default GETDATE()
   */
  private LocalDate docDate;

  /**
   * 狀態
   * 0:Draft, 1:Counted, 2:Approved, 3:Void
   * 對應 Enum: StockTakingStatus
   */
  private Integer status;

  /**
   * 全域欄位
   */
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
