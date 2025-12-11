package com.misstilo.cloth_erp_api.model.purchase.purchaseOrder;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderQuery {
    private Boolean confirmed;
    private Boolean signed;
    private String code;
    private String dateS;
    private String dateE;
    private List<Integer> supplierId;
    private String remark;
    private String createAtS;
    private String createAtE;
    private String updateAtS;
    private String updateAtE;
}
