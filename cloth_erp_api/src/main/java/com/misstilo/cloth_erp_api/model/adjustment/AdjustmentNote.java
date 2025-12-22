package com.misstilo.cloth_erp_api.model.adjustment;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 庫存調整單 (AdjustmentNotes)
 * [cite: 307]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdjustmentNote implements Serializable {
  /**
   * 調整單號 (PK)
   * e.g., ADJ2025...
   */
  private String adjDocNo;

  /**
   * 來源單號
   * [cite: 309] 通常關聯 StockTakingNotes.DocNo
   */
  private String sourceDocNo;

  /**
   * 調整原因
   * [cite: 310] e.g., 盤盈、盤虧、報廢
   */
  private String reason;

  /**
   * 調整時間
   */
  private LocalDateTime adjDate;

  /**
   * 全域欄位
   */
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
