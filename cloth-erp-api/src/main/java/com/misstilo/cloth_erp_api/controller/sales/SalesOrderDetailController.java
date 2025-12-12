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

import com.misstilo.cloth_erp_api.model.sales.salesOrderDetail.SalesOrderDetailCreate;
import com.misstilo.cloth_erp_api.model.sales.salesOrderDetail.SalesOrderDetailResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrderDetail.SalesOrderDetailUpdate;
import com.misstilo.cloth_erp_api.service.sales.SalesOrderDetailService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/sales-order-detail")
@Builder
public class SalesOrderDetailController {
    @Autowired
    private final SalesOrderDetailService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid SalesOrderDetailCreate model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid SalesOrderDetailUpdate model) {
        return service.update(model);
    }

    @GetMapping("/select/{salesOrderId}")
    public List<SalesOrderDetailResponse> select(@PathVariable @NotNull(message = "Select: SalesOrderId is required.") Integer salesOrderId) {
        return service.select(salesOrderId);
    }
}
