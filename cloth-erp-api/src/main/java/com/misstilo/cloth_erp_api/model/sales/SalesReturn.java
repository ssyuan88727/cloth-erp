package com.misstilo.cloth_erp_api.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 銷貨退回 (SalesReturns)
 * [cite: 269]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesReturn implements Serializable {
  /**
   * 退貨單號 (PK)
   * [cite: 270] e.g., SR202512...
   */
  private String returnDocNo;

  /**
   * 退貨時間
   * [cite: 271] Default GETDATE()
   */
  private LocalDateTime returnDate;

  /**
   * 關聯原始銷貨明細 (FK)
   * [cite: 272] Crucial: 用於查找原始 CostAtMoment 與 UnitPrice
   */
  private Integer originalSoDetailId;

  /**
   * 退貨數量
   * [cite: 274]
   */
  private Integer qty;

  /**
   * 退貨理由 (FK)
   * [cite: 275] 關聯 ReturnReasons
   */
  private Integer reasonId;

  /**
   * 退款方式
   * [cite: 277] 1: CASH, 2: CREDIT
   * 對應 Enum: RefundType
   */
  private Integer refundType;

  /**
   * 退款對帳狀態
   * [cite: 281] 0: Pending, 1: Refunded (已退款)
   * 僅當此狀態為 1 時，財務報表才扣除現金流
   */
  private Boolean isRefunded;

  /**
   * 逆物流費用
   * 賣家負擔的運費成本
   */
  private BigDecimal returnShippingFee;

  /**
   * 平台退還的手續費
   * 若有退還，紀錄為正數 (抵銷原訂單費用)
   */
  private BigDecimal refundedFee;

  /**
   * 對帳狀態 (針對退款)
   * [cite: 287] 0: Pending, 1: Refunded
   * (註：規格書與 isRefunded 有些許重疊，但通常 Reconciliation 指的是「與金流平台」的對帳)
   */
  private Boolean reconciliationStatus;

  /**
   * 全域欄位
   * [cite: 53]
   */
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final long serialVersionUID = 1L;
}
