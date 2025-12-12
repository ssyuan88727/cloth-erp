package com.misstilo.cloth_erp_api.model.sales.salesOrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderStatusResponse {
        private Integer id;
        private String name;
}
