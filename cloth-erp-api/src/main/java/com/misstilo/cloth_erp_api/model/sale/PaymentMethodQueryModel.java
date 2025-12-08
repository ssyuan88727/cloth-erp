package com.misstilo.cloth_erp_api.model.sale;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodQueryModel {
    private Integer id;
    @Size(max = 10, message = "付款方式名稱不可超過10個字")
    private String name;
}
