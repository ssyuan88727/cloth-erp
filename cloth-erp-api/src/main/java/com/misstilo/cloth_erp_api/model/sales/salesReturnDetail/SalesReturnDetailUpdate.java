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
public class SalesReturnDetailUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    private Integer qty;
    private BigDecimal refundPrc;
}
