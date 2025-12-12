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

import com.misstilo.cloth_erp_api.model.sales.salesReturnDetail.SalesReturnDetailCreate;
import com.misstilo.cloth_erp_api.model.sales.salesReturnDetail.SalesReturnDetailResponse;
import com.misstilo.cloth_erp_api.model.sales.salesReturnDetail.SalesReturnDetailUpdate;
import com.misstilo.cloth_erp_api.service.sales.SalesReturnDetailService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/sales-return-detail")
@Builder
public class SalesReturnDetailController {
    @Autowired
    private final SalesReturnDetailService service;

    @PostMapping("/insert")
    public Integer insert(@RequestBody @Valid SalesReturnDetailCreate model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid SalesReturnDetailUpdate model) {
        return service.update(model);
    }

    @GetMapping("/select/{salesReturnId}")
    public List<SalesReturnDetailResponse> select(@PathVariable @NotNull(message = "Select: SalesReturnId is required.") Integer salesReturnId) {
        return service.select(salesReturnId);
    }
}
