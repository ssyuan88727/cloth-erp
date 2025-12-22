package com.misstilo.cloth_erp_api.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 銷貨單 (SalesOrders)
 * [cite: 245]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrder implements Serializable {
  /**
   * 單號 (PK)
   * [cite: 246] e.g., SO202512210001
   */
  private String docNo;

  /**
   * 銷貨時間
   * [cite: 247]
   */
  private LocalDateTime docDate;

  /**
   * 會員 (FK)
   * [cite: 248] 預設 1 為 Guest
   */
  private Integer memberId;

  /**
   * 銷售通路 (FK)
   * [cite: 249] 用於計算手續費率
   */
  private Integer channelId;

  /**
   * 配送方式 (FK)
   * [cite: 250]
   */
  private Integer deliveryMethodId;

  /**
   * 物流單號
   * [cite: 251] Nullable
   */
  private String trackingNo;

  /**
   * 網購平台訂單編號
   * [cite: 252] Nullable
   */
  private String externalDocNo;

  /**
   * 手續費成本
   * 依費率計算後寫死 (Snapshot)
   */
  private BigDecimal platformFee;

  /**
   * 付款狀態
   * 0: Unpaid, 1: Paid (BIT)
   */
  private Boolean paymentStatus;

  /**
   * 對帳狀態
   * [cite: 255-258] 0: Unreconciled (錢未入帳), 1: Reconciled (確認撥款)
   */
  private Boolean reconciliationStatus;

  /**
   * 實收金額
   * [cite: 259]
   */
  private BigDecimal paidAmount;

  /**
   * 全域欄位
   * [cite: 53]
   */
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
