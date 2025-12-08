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
public class PurchaseReturnDetailModel {
  private Integer id;
  private Integer purchaseReturnId;
  @NotNull(message = "商品不可為空")
  private Integer productSkuId;
  private String productSkuCode;
  @NotNull(message = "退貨數量不可為空")
  private Integer qty;
  private Double costPrc;
  private Double subTot;
}
