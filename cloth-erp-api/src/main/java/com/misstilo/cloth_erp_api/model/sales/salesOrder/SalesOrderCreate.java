package com.misstilo.cloth_erp_api.model.sales.salesOrder;

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
public class SalesOrderCreate {
        private String code;
        private String date;
        @Size(max = 20, message = "原始單號不可超過20個字")
        private String originalCode;
        private Integer memberId;
        @NotNull(message = "出貨店點不可為空")
        private Integer storeId;
        @NotNull(message = "銷售平台不可為空")
        private Integer salesPlatformId;
        private BigDecimal deliveryFee;
        private BigDecimal platformFee;
        @NotNull(message = "訂單狀態不可為空")
        private Integer status;
        @NotNull(message = "付款方式不可為空")
        private Integer paymentMethodId;
        @Size(max = 255, message = "備註不可超過255個字")
        private String remark;
}
