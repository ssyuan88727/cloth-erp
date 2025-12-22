package com.misstilo.cloth_erp_api.model.inventory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
// 引入我們上一階段建立的 Enum
import com.misstilo.cloth_erp_api.model.enums.StockDocType;

/**
 * 庫存流水帳 (StockTransactionLogs)
 * 確保庫存歷程可追溯
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockTransactionLog implements Serializable {
  /**
   * 流水號 (PK, Identity)
   * 
   */
  private Integer logId;

  /**
   * 單據類型代碼
   * Values: 1:PO_IN, 2:PO_RET, 3:SO_OUT...
   */
  private Integer docType;

  /**
   * 來源單號
   * e.g., 'PO202512210001'
   */
  private String docNo;

  /**
   * 來源明細ID
   * 關聯 PODetails/SODetails/AdjDetails 的 ID
   */
  private Integer refDetailID;

  /**
   * 異動 SKU
   * 
   */
  private Integer skuId;

  /**
   * 異動數量
   * 進貨為正，銷貨為負
   */
  private Integer qtyChange;

  /**
   * 異動前平均成本
   * DECIMAL(18, 4)
   */
  private BigDecimal costBefore;

  /**
   * 異動後平均成本
   * DECIMAL(18, 4)
   */
  private BigDecimal costAfter;

  /**
   * 發生時間
   * Default GETDATE()
   */
  private LocalDateTime createdAt;

  private static final long serialVersionUID = 1L;

  /**
   * [Helper Method] 取得 Enum 型態的單據類型
   * 方便業務邏輯層使用，避免直接操作 Integer
   */
  public StockDocType getDocTypeEnum() {
    if (this.docType != null) {
      for (StockDocType type : StockDocType.values()) {
        if (type.getCode().equals(this.docType)) {
          return type;
        }
      }
    }
    return null;
  }
}
