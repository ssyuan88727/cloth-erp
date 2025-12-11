package com.misstilo.cloth_erp_api.controller.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryResponse;
import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryUpdate;
import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryCreate;
import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryQuery;
import com.misstilo.cloth_erp_api.model.response.ResponseModel;
import com.misstilo.cloth_erp_api.service.inventory.InventoryService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Controller
@Builder
public class InventoryController {
  @Autowired
  private final InventoryService service;

  @PostMapping("/insert")
  public ResponseModel<Integer> insert(@RequestBody @Valid InventoryCreate model) {
    return ResponseModel.success(service.insert(model));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseModel<Integer> delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
    return ResponseModel.success(service.delete(id));
  }

  @PutMapping("/update")
  public ResponseModel<Integer> update(@RequestBody @Valid InventoryUpdate model) {
    return ResponseModel.success(service.update(model));
  }

  @GetMapping("/select")
  public ResponseModel<List<InventoryResponse>> select(@Valid InventoryQuery model) {
    return ResponseModel.success(service.select(model));
  }
}
