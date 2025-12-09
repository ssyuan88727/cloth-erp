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
public class InventoryCreate {
    @NotNull(message = "店點不可為空")
    private Integer storeId;
    @NotNull(message = "商品不可為空")
    private Integer productSkuId;
    private Integer currentQty;
    private Integer purchaseQty;
    private Integer purchaseReturnQty;
    private Integer saleQty;
    private Integer saleReturnQty;
}
