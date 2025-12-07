package com.misstilo.cloth_erp_api.model.product;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryQueryModel {
  private Integer id;
  private List<Integer> storeId;
  private List<Integer> productSkuId;
  private String productCode;
  private Integer currentQtyS;
  private Integer currentQtyE;
  private Integer purchaseQtyS;
  private Integer purchaseQtyE;
  private Integer purchaseReturnQtyS;
  private Integer purchaseReturnQtyE;
  private Integer saleQtyS;
  private Integer saleQtyE;
  private Integer saleReturnQtyS;
  private Integer saleReturnQtyE;
  private Integer actualQtyS;
  private Integer actualQtyE;
}
