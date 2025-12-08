package com.misstilo.cloth_erp_api.controller.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misstilo.cloth_erp_api.model.sale.PaymentMethodModel;
import com.misstilo.cloth_erp_api.model.sale.PaymentMethodQueryModel;
import com.misstilo.cloth_erp_api.service.sale.PaymentMethodService;

import jakarta.validation.Valid;
import lombok.Builder;

@RestController
@RequestMapping("/payment-method")
@Builder
public class PaymentMethodController {
    @Autowired
    private final PaymentMethodService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid PaymentMethodModel model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid PaymentMethodModel model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<PaymentMethodModel> select(@Valid PaymentMethodQueryModel model) {
        return service.select(model);
    }
}
