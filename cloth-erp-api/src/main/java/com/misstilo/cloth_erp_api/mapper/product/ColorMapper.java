package com.misstilo.cloth_erp_api.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.ColorModel;
import com.misstilo.cloth_erp_api.model.product.ColorQueryModel;

@Mapper
public interface ColorMapper {
  Integer insert(ColorModel model);

  Integer delete(Integer id);

  Integer update(ColorModel model);

  List<ColorModel> select(ColorQueryModel model);
}
