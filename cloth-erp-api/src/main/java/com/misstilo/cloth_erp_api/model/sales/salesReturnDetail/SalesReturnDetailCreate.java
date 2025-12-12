package com.misstilo.cloth_erp_api.model.sales.salesReturnDetail;

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
public class SalesReturnDetailCreate {
    @NotNull(message = "Create: SalesReturnId is required.")
    private Integer salesReturnId;
    @NotNull(message = "商品不可為空")
    private Integer productSkuId;
    private Integer qty;
    private BigDecimal refundPrc;
}
