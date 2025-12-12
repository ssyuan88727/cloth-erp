package com.misstilo.cloth_erp_api.model.sales.salesOrderStatus;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderStatusQuery {
        @Size(max = 10, message = "名稱不可超過10個字")
        private String name;
}
