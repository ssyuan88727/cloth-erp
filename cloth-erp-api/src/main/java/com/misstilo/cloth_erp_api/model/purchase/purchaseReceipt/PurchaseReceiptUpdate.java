package com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt;

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
public class PurchaseReceiptUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    private Boolean confirmed;
    private Boolean signed;
    @Size(max = 20, message = "廠商單號不可超過20個字")
    private String originalCode;
    @Size(max = 255, message = "備註不可超過255個字")
    private String remark;
}
