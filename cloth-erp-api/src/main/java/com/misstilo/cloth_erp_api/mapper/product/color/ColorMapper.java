package com.misstilo.cloth_erp_api.mapper.product.color;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.color.ColorResponse;
import com.misstilo.cloth_erp_api.model.product.color.ColorUpdate;
import com.misstilo.cloth_erp_api.model.product.color.ColorCreate;
import com.misstilo.cloth_erp_api.model.product.color.ColorQuery;

@Mapper
public interface ColorMapper {
  Integer insert(ColorCreate model);

  Integer delete(Integer id);

  Integer update(ColorUpdate model);

  List<ColorResponse> select(ColorQuery model);

  String getCodeById(Integer id);
}
