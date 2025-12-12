package com.misstilo.cloth_erp_api.model.sales.salesOrder;

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
public class SalesOrderUpdate {
        @NotNull(message = "Update: Id is required.")
        private Integer id;
        @Size(max = 20, message = "原始單號不可超過20個字")
        private String originalCode;
        private Integer memberId;
        private Integer totQty;
        private Integer totAmt;
        private Integer discAmt;
        private Integer taxAmt;
        private Integer deliveryFee;
        private Integer platformFee;
        @NotNull(message = "訂單狀態不可為空")
        private Integer status;
        @NotNull(message = "銷售平台不可為空")
        private Integer paymentMethodId;
        private String remark;
}
