package com.misstilo.cloth_erp_api.model.sales.salesOrderDetail;

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
public class SalesOrderDetailCreate {
    @NotNull(message = "Create: SalesOrderId is required.")
    private Integer salesOrderId;
    @NotNull(message = "商品不可為空")
    private Integer productSkuId;
    private Integer qty;
    private BigDecimal sellPrc;
    private BigDecimal discPrc;
}
