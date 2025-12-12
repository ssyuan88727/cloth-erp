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
public class PurchaseReturnDetailUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    private Integer returnReasonId;
    private Integer qty;
    private BigDecimal costPrc;
}
