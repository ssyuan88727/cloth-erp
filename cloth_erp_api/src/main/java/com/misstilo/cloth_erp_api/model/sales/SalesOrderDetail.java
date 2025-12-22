package com.misstilo.cloth_erp_api.model.sales;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 銷貨明細 (SODetails)
 * [cite: 260]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderDetail implements Serializable {
  /**
   * 明細流水號 (PK, Identity)
   * [cite: 261]
   */
  private Integer detailId;

  /**
   * 關聯 SO (FK)
   * [cite: 262]
   */
  private String docNo;

  /**
   * 銷貨品項 (FK)
   * [cite: 263]
   */
  private Integer skuId;

  /**
   * 數量
   * [cite: 264]
   */
  private Integer qty;

  /**
   * 售價快照 (Snapshot)
   * [cite: 265] SO 建立當下寫入
   */
  private BigDecimal unitPrice;

  /**
   * 成本快照 (Snapshot)
   * [cite: 267-268] SO 建立當下的 Inventory.AvgCost
   * 用於鎖定該筆交易的利潤計算
   */
  private BigDecimal costAtMoment;

  private static final long serialVersionUID = 1L;
}
