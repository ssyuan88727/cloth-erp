package com.misstilo.cloth_erp_api.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.ProductSkuModel;

@Mapper
public interface ProductSkuMapper {
  Integer insert(ProductSkuModel model);

  Integer delete(Integer id);

  Integer update(ProductSkuModel model);

  List<ProductSkuModel> select(Integer id);
}
