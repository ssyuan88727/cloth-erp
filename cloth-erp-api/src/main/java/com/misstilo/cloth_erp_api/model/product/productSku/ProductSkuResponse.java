package com.misstilo.cloth_erp_api.model.product.productSku;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuResponse {
  private Integer id;
  private String skuCode;
  private BigDecimal costPrc;
  private Boolean isActive;
}
