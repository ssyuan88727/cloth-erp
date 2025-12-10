package com.misstilo.cloth_erp_api.model.inventory.inventory;

import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuResponse;
import com.misstilo.cloth_erp_api.model.store.store.StoreResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {
  private Integer id;
  private StoreResponse store;
  private ProductSkuResponse productSku;
  private Integer currentQty;
  private Integer purchaseQty;
  private Integer purchaseReturnQty;
  private Integer saleQty;
  private Integer saleReturnQty;
  private Integer actualQty;
}
