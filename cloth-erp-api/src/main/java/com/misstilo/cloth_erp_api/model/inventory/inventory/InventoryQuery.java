package com.misstilo.cloth_erp_api.model.inventory.inventory;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryQuery {
  private List<Integer> storeId;
  private List<Integer> productSkuId;
}
