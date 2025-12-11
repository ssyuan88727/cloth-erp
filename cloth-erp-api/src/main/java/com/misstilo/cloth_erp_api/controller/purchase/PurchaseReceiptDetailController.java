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

import com.misstilo.cloth_erp_api.model.purchase.purchaseReceiptDetail.PurchaseReceiptDetailCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceiptDetail.PurchaseReceiptDetailResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceiptDetail.PurchaseReceiptDetailUpdate;
import com.misstilo.cloth_erp_api.service.purchase.PurchaseReceiptDetailService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/purchase-receipt-detail")
@Builder
public class PurchaseReceiptDetailController {
    @Autowired
    private final PurchaseReceiptDetailService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid PurchaseReceiptDetailCreate model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid PurchaseReceiptDetailUpdate model) {
        return service.update(model);
    }

    @GetMapping("/select/{purchaseReceiptId}")
    public List<PurchaseReceiptDetailResponse> select(
            @PathVariable @NotNull(message = "Select: PurchaseReceiptId is required.") Integer purchaseReceiptId) {
        return service.select(purchaseReceiptId);
    }
}
