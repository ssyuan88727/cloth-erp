package com.misstilo.cloth_erp_api.model.inventory.inventory;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryUpdate {
    @NotNull(message = "Update: Id should not be null.")
    private Integer id;
    private Integer currentQty;
    private Integer purchaseQty;
    private Integer purchaseReturnQty;
    private Integer saleQty;
    private Integer saleReturnQty;
}
