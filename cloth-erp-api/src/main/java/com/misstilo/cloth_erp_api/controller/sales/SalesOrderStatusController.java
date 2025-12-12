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

import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusCreate;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusQuery;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusUpdate;
import com.misstilo.cloth_erp_api.service.sales.SalesOrderStatusService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/sales-order-status")
@Builder
public class SalesOrderStatusController {
    @Autowired
    private final SalesOrderStatusService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid SalesOrderStatusCreate model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid SalesOrderStatusUpdate model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<SalesOrderStatusResponse> select(@Valid SalesOrderStatusQuery model) {
        return service.select(model);
    }
}
