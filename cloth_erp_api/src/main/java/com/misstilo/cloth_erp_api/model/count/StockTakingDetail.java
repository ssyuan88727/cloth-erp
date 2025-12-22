package com.misstilo.cloth_erp_api.model.count;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 盤點明細 (StockTakingDetails)
 * [cite: 300]
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockTakingDetail implements Serializable {
  /**
   * 流水號 (PK)
   */
  private Integer detailId;

  /**
   * 關聯盤點單 (FK)
   */
  private String docNo;

  /**
   * 盤點品項 (FK)
   */
  private Integer skuId;

  /**
   * 系統庫存快照
   * [cite: 304] 建立盤點單當下的 Inventory.Quantity
   */
  private Integer systemQty;

  /**
   * 實盤數量
   * [cite: 305] 使用者輸入
   */
  private Integer countQty;

  /**
   * 差異量 (Computed Column)
   * CountQty - SystemQty
   * Note: 此欄位在 insert/update 時通常忽略，僅用於 select
   */
  private Integer diffQty;

  private static final long serialVersionUID = 1L;

  /**
   * [Helper] 用於 Java 層預先計算差異 (若前端需要即時回饋)
   */
  public Integer calculateDiff() {
    if (this.countQty != null && this.systemQty != null) {
      return this.countQty - this.systemQty;
    }
    return 0;
  }
}
