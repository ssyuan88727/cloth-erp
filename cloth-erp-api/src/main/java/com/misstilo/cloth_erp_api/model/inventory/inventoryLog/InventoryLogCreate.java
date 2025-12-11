package com.misstilo.cloth_erp_api.model.inventory.inventoryLog;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryLogCreate {
    @NotNull(message = "Create: InventoryLogTypeId is required.")
    private Integer inventoryLogTypeId;
    @NotNull(message = "Create: StoreId is required.")
    private Integer storeId;
    @NotNull(message = "Create: ProductSkuId is required.")
    private Integer productSkuId;
    private Integer qty;
    private Integer beforeQty;
}
