package com.misstilo.cloth_erp_api.model.sales.salesReturn;

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
public class SalesReturnCreate {
    private String code;
    private String date;
    private Integer salesOrderId;
    @NotNull(message = "退回理由不可為空")
    private Integer returnReasonId;
    @Size(max = 255, message = "備註不可超過255個字")
    private String remark;
}
