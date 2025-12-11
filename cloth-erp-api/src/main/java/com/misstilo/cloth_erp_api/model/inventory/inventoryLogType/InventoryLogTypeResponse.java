package com.misstilo.cloth_erp_api.model.inventory.inventoryLogType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLogTypeResponse {
    private Integer id;
    private String name;
}
