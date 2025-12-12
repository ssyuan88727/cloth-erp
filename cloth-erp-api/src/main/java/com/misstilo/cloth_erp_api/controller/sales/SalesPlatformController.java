package com.misstilo.cloth_erp_api.controller.sales;

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

import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformCreate;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformQuery;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformResponse;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformUpdate;
import com.misstilo.cloth_erp_api.service.sales.SalesPlatformService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/sales-platform")
@Builder
public class SalesPlatformController {
    @Autowired
    private final SalesPlatformService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid SalesPlatformCreate model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid SalesPlatformUpdate model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<SalesPlatformResponse> select(@Valid SalesPlatformQuery model) {
        return service.select(model);
    }
}
