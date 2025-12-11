package com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail;

import java.math.BigDecimal;

import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDetailResponse {
    private Integer id;
    private Integer purchaseOrderId;
    private ProductSkuResponse productSku;
    private Integer purchaseQty;
    private Integer receivedQty;
    private Integer undeliveredQty;
    private BigDecimal costPrc;
    private BigDecimal subTot;
}
