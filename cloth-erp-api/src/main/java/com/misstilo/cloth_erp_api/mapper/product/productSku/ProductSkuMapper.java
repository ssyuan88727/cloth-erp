package com.misstilo.cloth_erp_api.mapper.product.productSku;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.prosuctSku.ProductSkuResponse;

@Mapper
public interface ProductSkuMapper {
  Integer insert(ProductSkuResponse model);

  Integer delete(Integer id);

  Integer update(ProductSkuResponse model);

  List<ProductSkuResponse> select(Integer id);
}
