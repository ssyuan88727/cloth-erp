package com.misstilo.cloth_erp_api.model.inventory.inventoryLog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLogResponse {
    private Integer id;
    private String inventoryLogTypeName;
    private String storeName;
    private String productSkuCode;
    private Integer qty;
    private Integer beforeQty;
    private Integer afterQty;
    private String createAt; 
}
