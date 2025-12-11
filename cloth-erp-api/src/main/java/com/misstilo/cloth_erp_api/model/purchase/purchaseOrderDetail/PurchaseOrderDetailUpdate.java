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
public class PurchaseOrderDetailUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    @NotNull(message = "採購數量不可為空")
    private Integer purchaseQty;
    private Integer ReceiveQty;
    private Integer UndeliveredQty;
    @NotNull(message = "進貨價不可為空")
    private BigDecimal costPrc;
}
