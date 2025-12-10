package com.misstilo.cloth_erp_api.model.product.productTagRel;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductTagRelCreate {
    @NotNull(message = "Create: ProductId is required.")
    private Integer productId;
    @NotNull(message = "Create: TagId is required.")
    private Integer tagId;
}
