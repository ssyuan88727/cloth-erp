package com.misstilo.cloth_erp_api.controller.supplier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misstilo.cloth_erp_api.model.response.ResponseModel;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierCreate;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierQuery;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierResponse;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierUpdate;
import com.misstilo.cloth_erp_api.service.supplier.SupplierService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/supplier")
@Builder
public class SupplierController {
    @Autowired
    private final SupplierService service;

    @PostMapping("/insert")
    public ResponseModel<Integer> insert(@RequestBody @Valid SupplierCreate model) {
        return ResponseModel.success(service.insert(model));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseModel<Integer> delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return ResponseModel.success(service.delete(id));
    }

    @PutMapping("/update")
    public ResponseModel<Integer> update(@RequestBody @Valid SupplierUpdate model) {
        return ResponseModel.success(service.update(model));
    }

    @GetMapping("/select")
    public ResponseModel<List<SupplierResponse>> select(@Valid SupplierQuery model) {
        return ResponseModel.success(service.select(model));
    }
}
