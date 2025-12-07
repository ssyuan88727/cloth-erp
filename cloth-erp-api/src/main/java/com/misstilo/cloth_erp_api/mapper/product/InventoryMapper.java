package com.misstilo.cloth_erp_api.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.InventoryModel;
import com.misstilo.cloth_erp_api.model.product.InventoryQueryModel;

@Mapper
public interface InventoryMapper {
  Integer insert(InventoryModel model);

  Integer delete(Integer id);

  Integer update(InventoryModel model);

  List<InventoryModel> select(InventoryQueryModel model);
}
