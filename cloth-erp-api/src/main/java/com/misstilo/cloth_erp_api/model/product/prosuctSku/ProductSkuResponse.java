package com.misstilo.cloth_erp_api.model.product.prosuctSku;

import java.math.BigDecimal;

import com.misstilo.cloth_erp_api.model.product.color.ColorResponse;
import com.misstilo.cloth_erp_api.model.product.size.SizeModel;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierResponse;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuResponse {
  @NotNull(message = "Id should not be null.")
  private Integer id;
  @NotNull(message = "商品不可為空")
  private Integer productId;
  @NotNull(message = "供應商不可為空")
  private SupplierResponse supplier;
  @NotNull(message = "顏色不可為空")
  private ColorResponse color;
  @NotNull(message = "尺寸不可為空")
  private SizeModel size;
  private String skuCode;
  @NotNull(message = "成本價不可為空")
  private BigDecimal costPrc;
  private Boolean isActive;
}
