package com.misstilo.cloth_erp_api.mapper.product.productSku;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuCreate;
import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuResponse;
import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuUpdate;

@Mapper
public interface ProductSkuMapper {
  Integer insert(ProductSkuCreate model);

  Integer delete(Integer id);

  Integer update(ProductSkuUpdate model);

  List<ProductSkuResponse> select(Integer productId);
}
