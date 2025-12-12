package com.misstilo.cloth_erp_api.model.purchase.purchaseReturnDetail;

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
public class PurchaseReturnDetailCreate {
    @NotNull(message = "Create: PurchaseReturnId is required.")
    private Integer purchaseReturnId;
    @NotNull(message = "商品不可為空")
    private Integer productSkuId;
    @NotNull(message = "退回理由不可為空")
    private Integer returnReasonId;
    private Integer qty;
    private BigDecimal costPrc;
}
