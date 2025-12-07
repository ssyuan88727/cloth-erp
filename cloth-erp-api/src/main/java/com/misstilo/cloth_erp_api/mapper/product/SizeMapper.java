package com.misstilo.cloth_erp_api.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.SizeModel;
import com.misstilo.cloth_erp_api.model.product.SizeQueryModel;

@Mapper
public interface SizeMapper {
  Integer insert(SizeModel model);

  Integer delete(Integer id);

  Integer update(SizeModel model);

  List<SizeModel> select(SizeQueryModel model);
}
