package com.misstilo.cloth_erp_api.model.sale;

import jakarta.validation.constraints.NotBlank;
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
public class SalesOrderModel {
    private Integer id;
    @NotBlank(message = "訂單號不可為空")
    @Size(max = 20, message = "訂單號不可超過20個字")
    private String code;
    private String date;
    private Integer memberId;
    @NotNull(message = "銷售地點不可為空")
    private Integer storeId;
    private String storeName;
    @NotNull(message = "銷售平台不可為空")
    private Integer salesPlatformId;
    private String salesPlatformName;
    private Double totAmt;
    private Double discAmt;
    private Double taxAmt;
    private Double deliveryFee;
    private Double platformFee;
    private Integer status;
    @NotNull(message = "付款方式不可為空")
    private Integer paymentMethodId;
    private String paymentMethodName;
    @Size(max = 255, message = "備註不可超過255個字")
    private String remark;
    private String createAt;
    private String updateAt;
}
