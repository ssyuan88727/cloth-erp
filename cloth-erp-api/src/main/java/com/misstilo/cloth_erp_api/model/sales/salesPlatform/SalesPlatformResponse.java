package com.misstilo.cloth_erp_api.model.sales.salesPlatform;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesPlatformResponse {
    private Integer id;
    private String name;
}
