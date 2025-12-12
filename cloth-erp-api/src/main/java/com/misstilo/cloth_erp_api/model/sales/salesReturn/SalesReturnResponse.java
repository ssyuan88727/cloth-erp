package com.misstilo.cloth_erp_api.model.sales.salesReturn;

import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesReturnResponse {
    private Integer id;
    private Boolean confirmed;
    private Boolean signed;
    private String code;
    private String date;
    private SalesOrderResponse salesOrder;
    private ReturnReasonResponse returnReason;
    private Integer totQty;
    private Double totAmt;
    private String remark;
    private String createAt;
    private String updateAt;
}
