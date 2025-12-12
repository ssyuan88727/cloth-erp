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

import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderCreate;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderQuery;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderUpdate;
import com.misstilo.cloth_erp_api.service.sales.SalesOrderService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/sales-order")
@Builder
public class SalesOrderController {
    @Autowired
    private final SalesOrderService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid SalesOrderCreate model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid SalesOrderUpdate model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<SalesOrderResponse> select(@Valid SalesOrderQuery model) {
        return service.select(model);
    }
}
