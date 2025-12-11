package com.misstilo.cloth_erp_api.model.purchase.purchaseReceiptDetail;

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
public class PurchaseReceiptDetailUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    @NotNull(message = "收貨數量不可為空")
    private Integer qty;
    @NotNull(message = "進貨價不可為空")
    private BigDecimal costPrc;
}
