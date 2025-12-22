package com.misstilo.cloth_erp_api.model.adjustment;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 調整明細 (AdjustmentDetails)
 * [cite: 312]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdjustmentDetail implements Serializable {
  /**
   * 流水號 (PK)
   */
  private Integer detailId;

  /**
   * 關聯調整單 (FK)
   */
  private String adjDocNo;

  /**
   * 調整品項 (FK)
   */
  private Integer skuId;

  /**
   * 調整數量
   * [cite: 316] 正數增加庫存，負數減少庫存
   */
  private Integer adjQty;

  /**
   * 成本快照
   * [cite: 317] 用於會計帳紀錄損失或資產增加
   * Logic: 系統優先使用 Current AvgCost，若為 0 則使用 PurchasePrice [cite: 438-439]
   */
  private BigDecimal costAtMoment;

  private static final long serialVersionUID = 1L;
}
