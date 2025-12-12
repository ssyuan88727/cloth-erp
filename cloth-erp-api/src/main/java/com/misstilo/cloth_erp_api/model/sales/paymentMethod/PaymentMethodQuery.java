package com.misstilo.cloth_erp_api.model.sales.paymentMethod;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodQuery {
    @Size(max = 10, message = "名稱不可超過10字")
    private String name;
}
