package com.misstilo.cloth_erp_api.model.procurement;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 進貨明細 (RIDetails)
 * [cite: 221]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceivingNoteDetail implements Serializable {
  /**
   * 流水號 (PK, Identity)
   * [cite: 222]
   */
  private Integer detailId;

  /**
   * 關聯進貨單 (FK)
   * [cite: 223]
   */
  private String riDocNo;

  /**
   * 進貨品項 (FK)
   * [cite: 224]
   */
  private Integer skuId;

  /**
   * 本次實收數量
   * [cite: 225]
   * Logic: 預設帶入 PO (OrderQty - ReceivedQty) [cite: 226]
   */
  private Integer qty;

  private static final long serialVersionUID = 1L;
}
