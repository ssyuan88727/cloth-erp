package com.misstilo.cloth_erp_api.model.purchase.purchaseReturn;

import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReturnResponse {
    private Integer id;
    private Boolean confirmed;
    private Boolean signed;
    private String code;
    private String date;
    private SupplierResponse supplier;
    private Integer totQty;
    private Double totAmt;
    private String remark;
    private String createAt;
    private String updateAt;
}
