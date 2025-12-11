package com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt;

import java.math.BigDecimal;

import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReceiptResponse {
    private Integer id;
    private Boolean confirmed;
    private Boolean signed;
    private String code;
    private String date;
    private SupplierResponse supplier;
    private String originalCode;
    private Integer totQty;
    private BigDecimal totAmt;
    private String remark;
    private String createAt;
    private String updateAt;
}
