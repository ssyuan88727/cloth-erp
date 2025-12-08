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

import com.misstilo.cloth_erp_api.model.sale.SalesPlatformModel;
import com.misstilo.cloth_erp_api.model.sale.SalesPlatformQueryModel;
import com.misstilo.cloth_erp_api.service.sale.SalesPlatformService;

import jakarta.validation.Valid;
import lombok.Builder;

@RestController
@RequestMapping("/sales-platform")
@Builder
public class SalesPlatformController {
    @Autowired
    private final SalesPlatformService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid SalesPlatformModel model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid SalesPlatformModel model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<SalesPlatformModel> select(@Valid SalesPlatformQueryModel model) {
        return service.select(model);
    }
}
