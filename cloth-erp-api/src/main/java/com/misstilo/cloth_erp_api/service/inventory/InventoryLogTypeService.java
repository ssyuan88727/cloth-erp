package com.misstilo.cloth_erp_api.service.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.inventory.inventoryLogType.InventoryLogTypeMapper;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeCreate;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeQuery;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeResponse;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeUpdate;

import lombok.Builder;

@Service
@Builder
public class InventoryLogTypeService {
    @Autowired
    private final InventoryLogTypeMapper mapper;

    @Transactional
    public Integer insert(InventoryLogTypeCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(InventoryLogTypeUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<InventoryLogTypeResponse> select(InventoryLogTypeQuery model) {
        return mapper.select(model);
    }
}
