package com.misstilo.cloth_erp_api.model.product.tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagResponse {
    private Integer id;
    private String name;
}
