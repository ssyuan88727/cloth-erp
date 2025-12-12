package com.misstilo.cloth_erp_api.model.sales.salesOrderDetail;

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
public class SalesOrderDetailResponse {
    private Integer id;
    private Integer salesOrderId;
    private ProductSkuResponse productSku;
    private Integer qty;
    private BigDecimal sellPrc;
    private BigDecimal discPrc;
    private BigDecimal subTot;
}
