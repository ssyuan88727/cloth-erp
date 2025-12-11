package com.misstilo.cloth_erp_api.model.purchase.purchaseReceiptDetail;

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
public class PurchaseReceiptDetailResponse {
    private Integer id;
    private Integer purchaseReceiptId;
    private ProductSkuResponse productSku;
    private Integer qty;
    private BigDecimal costPrc;
    private BigDecimal subTot;
}
