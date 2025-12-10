package com.misstilo.cloth_erp_api.mapper.product.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.product.ProductResponse;
import com.misstilo.cloth_erp_api.model.product.product.ProductUpdate;
import com.misstilo.cloth_erp_api.model.product.product.ProductCreate;
import com.misstilo.cloth_erp_api.model.product.product.ProductQuery;

@Mapper
public interface ProductMapper {
  Integer insert(ProductCreate model);

  Integer delete(Integer id);

  Integer update(ProductUpdate model);

  List<ProductResponse> select(ProductQuery model);

  String getCodeById(Integer id);
}
