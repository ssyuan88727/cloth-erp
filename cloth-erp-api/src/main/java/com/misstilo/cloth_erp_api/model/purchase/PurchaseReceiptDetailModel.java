package com.misstilo.cloth_erp_api.model.purchase;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReceiptDetailModel {
  private Integer id;
  private Integer purchaseReceiptId;
  @NotNull(message = "商品不可為空")
  private Integer productSkuId;
  private String productSkuCode;
  @NotNull(message = "收貨數量不可為空")
  private Integer qty;
  private Double costPrc;
  private Double subTot;
}
