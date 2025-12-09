package com.misstilo.cloth_erp_api.mapper.inventory.inventory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryResponse;
import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryUpdate;
import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryCreate;
import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryQuery;

@Mapper
public interface InventoryMapper {
  Integer insert(InventoryCreate model);

  Integer delete(Integer id);

  Integer update(InventoryUpdate model);

  List<InventoryResponse> select(InventoryQuery model);
}
