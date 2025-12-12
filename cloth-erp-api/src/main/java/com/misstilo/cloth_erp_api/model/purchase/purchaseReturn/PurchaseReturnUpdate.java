package com.misstilo.cloth_erp_api.model.purchase.purchaseReturn;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReturnUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    private Boolean confirmed;
    private Boolean signed;
    @Size(max = 255, message = "備註不可超過255個字")
    private String remark;
}
