package com.misstilo.cloth_erp_api.mapper.product.size;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.size.SizeResponse;
import com.misstilo.cloth_erp_api.model.product.size.SizeUpdate;
import com.misstilo.cloth_erp_api.model.product.size.SizeCreate;
import com.misstilo.cloth_erp_api.model.product.size.SizeQuery;

@Mapper
public interface SizeMapper {
  Integer insert(SizeCreate model);

  Integer delete(Integer id);

  Integer update(SizeUpdate model);

  List<SizeResponse> select(SizeQuery model);

  String getCodeById(Integer id);
}
