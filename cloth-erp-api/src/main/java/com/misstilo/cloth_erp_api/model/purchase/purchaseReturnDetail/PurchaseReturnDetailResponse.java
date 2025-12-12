package com.misstilo.cloth_erp_api.model.purchase.purchaseReturnDetail;

import java.math.BigDecimal;

import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonResponse;
import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseReturnDetailResponse {
    private Integer id;
    private Integer purchaseReturnId;
    private ProductSkuResponse productSku;
    private ReturnReasonResponse returnReason;
    private Integer qty;
    private BigDecimal costPrc;
    private BigDecimal subTot;
}
