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

import com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail.PurchaseOrderDetailCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail.PurchaseOrderDetailResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail.PurchaseOrderDetailUpdate;
import com.misstilo.cloth_erp_api.service.purchase.PurchaseOrderDetailService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/purchase-order-detail")
@Builder
public class PurchaseOrderDetailController {
    @Autowired
    private final PurchaseOrderDetailService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid PurchaseOrderDetailCreate model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid PurchaseOrderDetailUpdate model) {
        return service.update(model);
    }

    @GetMapping("/select/{purchaseOrderId}")
    public List<PurchaseOrderDetailResponse> select(
            @PathVariable @NotNull(message = "Select: PurchaseOrderId is required.") Integer purchaseOrderId) {
        return service.select(purchaseOrderId);
    }
}
