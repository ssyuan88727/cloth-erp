package com.misstilo.cloth_erp_api.controller.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeCreate;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeQuery;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeResponse;
import com.misstilo.cloth_erp_api.model.inventory.inventoryLogType.InventoryLogTypeUpdate;
import com.misstilo.cloth_erp_api.service.inventory.InventoryLogTypeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/inventory-log-type")
@Builder
public class InventoryLogTypeController {
    @Autowired
    private final InventoryLogTypeService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid InventoryLogTypeCreate model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid InventoryLogTypeUpdate model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<InventoryLogTypeResponse> select(@Valid InventoryLogTypeQuery model) {
        return service.select(model);
    }
}
