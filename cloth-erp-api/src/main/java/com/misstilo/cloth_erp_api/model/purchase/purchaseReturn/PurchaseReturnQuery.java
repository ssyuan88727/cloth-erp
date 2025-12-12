package com.misstilo.cloth_erp_api.model.purchase.purchaseReturn;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReturnQuery {
    private Boolean confirmed;
    private Boolean signed;
    @Size(max = 20, message = "單號不可超過20個字")
    private String code;
    private String dateS;
    private String dateE;
    private List<Integer> supplierId;
    @Size(max = 255, message = "備註不可超過255個字")
    private String remark;
    private String createAtS;
    private String createAtE;
    private String updateAtS;
    private String updateAtE;
}
