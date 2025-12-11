package com.misstilo.cloth_erp_api.model.inventory.inventoryLog;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLogQuery {
    private List<Integer> inventoryLogTypeId;
    private List<Integer> storeId;
    private List<Integer> productSkuId;
    private String createAtS;
    private String createAtE;
}
