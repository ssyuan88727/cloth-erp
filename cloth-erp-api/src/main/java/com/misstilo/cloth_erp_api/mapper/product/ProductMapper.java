package com.misstilo.cloth_erp_api.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.ProductModel;
import com.misstilo.cloth_erp_api.model.product.ProductQueryModel;

@Mapper
public interface ProductMapper {
  Integer insert(ProductModel model);

  Integer delete(Integer id);

  Integer update(ProductModel model);

  List<ProductModel> select(ProductQueryModel model);
}
