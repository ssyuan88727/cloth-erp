package com.misstilo.cloth_erp_api.model.purchase.purchaseOrder;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderUpdate {
    private Integer id;
    private Boolean confirmed;
    private Boolean signed;
    private String date;
    @Size(max = 255, message = "備註不可超過255字")
    private String remark;
}
