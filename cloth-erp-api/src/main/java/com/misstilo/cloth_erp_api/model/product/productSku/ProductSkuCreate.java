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
public class ProductSkuCreate {
    @NotNull(message = "Create: ProductId is required.")
    private Integer productId;
    @NotNull(message = "供應商不可為空")
    private Integer supplierId;
    @NotNull(message = "顏色不可為空")
    private Integer colorId;
    @NotNull(message = "尺寸不可為空")
    private Integer sizeId;
    private String skuCode;
    @NotNull(message = "成本價不可為空")
    private BigDecimal costPrc;
    private Boolean isActive;
}
