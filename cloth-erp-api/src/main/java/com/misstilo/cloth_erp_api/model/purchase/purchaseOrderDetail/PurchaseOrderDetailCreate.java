package com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDetailCreate {
    @NotNull(message = "Create: PurchaseOrderId is required.")
    private Integer purchaseOrderId;
    @NotNull(message = "商品不可為空")
    private Integer productSkuId;
    private Integer purchaseQty;
    private BigDecimal costPrc;
}
