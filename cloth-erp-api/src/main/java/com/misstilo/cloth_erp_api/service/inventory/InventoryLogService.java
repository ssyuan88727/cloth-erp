package com.misstilo.cloth_erp_api.service.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.inventory.inventoryLog.InventoryLogMapper;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLog.InventoryLogCreate;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLog.InventoryLogQuery;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLog.InventoryLogResponse;

import lombok.Builder;

@Service
@Builder
public class InventoryLogService {
    @Autowired
    private final InventoryLogMapper mapper;

    @Transactional
    public Integer insert(InventoryLogCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public List<InventoryLogResponse> select(InventoryLogQuery model) {
        return mapper.select(model);
    }
}
