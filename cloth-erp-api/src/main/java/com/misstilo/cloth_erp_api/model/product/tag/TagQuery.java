package com.misstilo.cloth_erp_api.model.product.tag;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagQuery {
    @Size(max = 10, message = "名稱最多10個字")
    private String name;
}
