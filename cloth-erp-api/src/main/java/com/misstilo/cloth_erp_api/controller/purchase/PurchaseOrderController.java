package com.misstilo.cloth_erp_api.controller.purchase;

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

import com.misstilo.cloth_erp_api.model.purchase.PurchaseOrderModel;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseOrderQueryModel;
import com.misstilo.cloth_erp_api.service.purchase.PurchaseOrderService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/purchase-order")
@Builder
public class PurchaseOrderController {
  @Autowired
  private final PurchaseOrderService service;

  @PostMapping("/insert")
  public Integer insert(@RequestBody @Valid PurchaseOrderModel model) {
    return service.insert(model);
  }

  @DeleteMapping("/delete/{id}")
  public Integer delete(@PathVariable @NotNull(message = "更新 ID 不可為空") Integer id) {
    return service.delete(id);
  }

  @PutMapping("/update")
  public Integer update(@RequestBody @Valid PurchaseOrderModel model) {
    return service.update(model);
  }

  @GetMapping("/select")
  public List<PurchaseOrderModel> select(PurchaseOrderQueryModel model) {
    return service.select(model);
  }
}
