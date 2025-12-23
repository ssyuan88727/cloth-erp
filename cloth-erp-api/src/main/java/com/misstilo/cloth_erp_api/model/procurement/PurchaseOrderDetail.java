package com.misstilo.cloth_erp_api.model.procurement;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 採購明細 (PODetails)
 * [cite: 203]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDetail implements Serializable {
  /**
   * 明細流水號 (PK, Identity)
   * [cite: 204]
   */
  private Integer detailId;

  /**
   * 關聯 PO (FK)
   * [cite: 205]
   */
  private String docNo;

  /**
   * 採購品項 (FK)
   * [cite: 206]
   */
  private Integer skuId;

  /**
   * 採購單價
   * [cite: 207] DECIMAL(18, 0)
   */
  private BigDecimal unitPrice;

  /**
   * 採購量
   * [cite: 211]
   */
  private Integer orderQty;

  /**
   * 已到貨量
   * [cite: 212] Default 0
   * Logic: 進貨單 Confirmed 時回寫此欄位 [cite: 486]
   */
  private Integer receivedQty;

  private static final long serialVersionUID = 1L;
}
