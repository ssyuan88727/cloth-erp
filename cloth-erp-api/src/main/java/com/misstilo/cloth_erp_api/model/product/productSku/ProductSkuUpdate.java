package com.misstilo.cloth_erp_api.model.product.productSku;

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
public class ProductSkuUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    @NotNull(message = "成本價不可為空")
    private BigDecimal costPrc;
    private Boolean isActive;
}
