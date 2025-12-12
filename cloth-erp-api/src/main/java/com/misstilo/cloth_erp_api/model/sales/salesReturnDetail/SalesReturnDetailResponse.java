package com.misstilo.cloth_erp_api.model.sales.salesReturnDetail;

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
public class SalesReturnDetailResponse {
    private Integer id;
    private Integer salesReturnId;
    private ProductSkuResponse productSku;
    private Integer qty;
    private BigDecimal refundPrc;
    private BigDecimal subTot;
}
