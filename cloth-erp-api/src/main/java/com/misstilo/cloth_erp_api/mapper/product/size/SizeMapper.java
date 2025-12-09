package com.misstilo.cloth_erp_api.mapper.product.size;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.size.SizeModel;
import com.misstilo.cloth_erp_api.model.product.size.SizeQueryModel;

@Mapper
public interface SizeMapper {
  Integer insert(SizeModel model);

  Integer delete(Integer id);

  Integer update(SizeModel model);

  List<SizeModel> select(SizeQueryModel model);
}
