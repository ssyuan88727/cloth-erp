package com.misstilo.cloth_erp_api.controller.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misstilo.cloth_erp_api.model.purchase.PurchaseReceiptDetailModel;
import com.misstilo.cloth_erp_api.service.purchase.PurchaseReceiptDetailService;

import lombok.Builder;

@RestController
@RequestMapping("/purchase-receipt-detail")
@Builder
public class PurchaseReceiptDetailController {
    @Autowired
    private final PurchaseReceiptDetailService service;

    @PostMapping("/insert")
    public Integer insert(PurchaseReceiptDetailModel model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(PurchaseReceiptDetailModel model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<PurchaseReceiptDetailModel> select(Integer purchaseReceiptId) {
        return service.select(purchaseReceiptId);
    }
}
