package com.misstilo.cloth_erp_api.model.inventory.inventoryLogType;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLogTypeQuery {
    @Size(max = 20, message = "名稱不可超過20字")
    private String name;
}
