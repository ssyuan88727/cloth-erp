package com.misstilo.cloth_erp_api.model.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryModel {
  private Integer id;
  @NotNull(message = "倉庫不可為空")
  private Integer storeId;
  private String storeName;
  @NotNull(message = "商品不可為空")
  private Integer productSkuId;
  private String productName;
  private Integer currentQty;
  private Integer purchaseQty;
  private Integer purchaseReturnQty;
  private Integer saleQty;
  private Integer saleReturnQty;
  private Integer actualQty;
}
