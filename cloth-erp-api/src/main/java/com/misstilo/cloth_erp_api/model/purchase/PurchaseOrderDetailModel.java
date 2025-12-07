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
public class PurchaseOrderDetailModel {
  private Integer id;
  private Integer purchaseOrderId;
  @NotNull(message = "商品不可為空")
  private Integer productSkuId;
  private String productSku;
  private String productSkuName;
  @NotNull(message = "採購數量不可為空")
  private Integer purchaseQty;
  private Integer receivedQty;
  private Integer undeliveredQty;
  private Double costPrc;
  private Double subTot;
}
