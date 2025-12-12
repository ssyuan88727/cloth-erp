package com.misstilo.cloth_erp_api.model.sales.salesOrder;

import com.misstilo.cloth_erp_api.model.member.member.MemberResponse;
import com.misstilo.cloth_erp_api.model.sales.paymentMethod.PaymentMethodResponse;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformResponse;
import com.misstilo.cloth_erp_api.model.store.store.StoreResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderResponse {
        private Integer id;
        private String code;
        private String date;
        private String originalCode;
        private MemberResponse member;
        private StoreResponse store;
        private SalesPlatformResponse salesPlatform;
        private Integer totQty;
        private Integer totAmt;
        private Integer discAmt;
        private Integer taxAmt;
        private Integer deliveryFee;
        private Integer platformFee;
        private Integer status;
        private PaymentMethodResponse paymentMethod;
        private String remark;
        private String createAt;
        private String updateAt;
}
