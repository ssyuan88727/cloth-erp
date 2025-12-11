package com.misstilo.cloth_erp_api.mapper.inventory.inventoryLog;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.inventory.inventoryLog.InventoryLogCreate;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLog.InventoryLogQuery;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLog.InventoryLogResponse;

@Mapper
public interface InventoryLogMapper {
    Integer insert(InventoryLogCreate model);

    List<InventoryLogResponse> select(InventoryLogQuery model);
}
