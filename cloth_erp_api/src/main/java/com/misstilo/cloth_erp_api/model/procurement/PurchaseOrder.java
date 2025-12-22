package com.misstilo.cloth_erp_api.model.procurement;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 採購單 (PurchaseOrders)
 * [cite: 194]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder implements Serializable {
  /**
   * 單號 (PK)
   * [cite: 195] e.g., PO202512210001
   */
  private String docNo;

  /**
   * 單據日期
   * DATE (不含時間)
   */
  private LocalDate docDate;

  /**
   * 狀態
   * [cite: 197] 0:Draft, 1:Confirmed, 2:Closed, 3:ForceClosed
   * 對應 Enum: PurchaseOrderStatus
   */
  private Integer status;

  /**
   * 供應商收據/發票號碼
   * [cite: 202] Nullable
   */
  private String externalDocNo;

  /**
   * [cite: 36] 全域欄位
   */
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
