package com.misstilo.cloth_erp_api.model.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuModel {
  private Integer id;
  @NotNull(message = "商品不可為空")
  private Integer productId;
  @NotNull(message = "供應商不可為空")
  private Integer supplierId;
  private String supplierName;
  @NotNull(message = "顏色不可為空")
  private Integer colorId;
  private String colorName;
  @NotNull(message = "尺寸不可為空")
  private Integer sizeId;
  private String sizeName;
  private String skuCode;
  @NotNull(message = "成本價不可為空")
  private BigDecimal costPrc;
  private Boolean isActive;
}
