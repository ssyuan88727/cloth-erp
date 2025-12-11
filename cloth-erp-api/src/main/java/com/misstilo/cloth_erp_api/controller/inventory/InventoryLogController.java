package com.misstilo.cloth_erp_api.controller.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misstilo.cloth_erp_api.model.inventory.inventoryLog.InventoryLogQuery;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLog.InventoryLogResponse;
import com.misstilo.cloth_erp_api.service.inventory.InventoryLogService;

import lombok.Builder;

@RestController
@RequestMapping("/inventory-log")
@Builder
public class InventoryLogController {
    @Autowired
    private final InventoryLogService service;

    @GetMapping("/select")
    public List<InventoryLogResponse> select(InventoryLogQuery model) {
        return service.select(model);
    }
}
