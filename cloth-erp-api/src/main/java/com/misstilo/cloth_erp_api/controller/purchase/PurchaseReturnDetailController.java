package com.misstilo.cloth_erp_api.controller.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misstilo.cloth_erp_api.model.purchase.PurchaseReturnDetailModel;
import com.misstilo.cloth_erp_api.service.purchase.PurchaseReturnDetailService;

import lombok.Builder;

@RestController
@RequestMapping("/purchase-return-detail")
@Builder
public class PurchaseReturnDetailController {
    @Autowired
    private final PurchaseReturnDetailService service;

    @PostMapping("/insert")
    public Integer insert(PurchaseReturnDetailModel model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(PurchaseReturnDetailModel model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<PurchaseReturnDetailModel> select(Integer purchaseReturnId) {
        return service.select(purchaseReturnId);
    }
}
