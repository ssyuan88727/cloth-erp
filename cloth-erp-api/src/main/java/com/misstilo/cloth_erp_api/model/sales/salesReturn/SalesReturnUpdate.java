package com.misstilo.cloth_erp_api.model.sales.salesReturn;

import java.math.BigDecimal;

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
public class SalesReturnUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    private Boolean confirmed;
    private Boolean signed;
    private Integer salesOrderId;
    @NotNull(message = "退回理由不可為空")
    private Integer returnReasonId;
    private Integer totQty;
    private BigDecimal totAmt;
    @Size(max = 255, message = "備註不可超過255個字")
    private String remark;
}
