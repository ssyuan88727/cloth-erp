package com.misstilo.cloth_erp_api.mapper.inventory.inventoryLogType;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeCreate;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeQuery;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeResponse;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeUpdate;

@Mapper
public interface InventoryLogTypeMapper {
    Integer insert(InventoryLogTypeCreate model);

    Integer delete(Integer id);

    Integer update(InventoryLogTypeUpdate model);

    List<InventoryLogTypeResponse> select(InventoryLogTypeQuery model);
}
