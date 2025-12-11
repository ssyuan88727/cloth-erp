package com.misstilo.cloth_erp_api.controller.product;

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

import com.misstilo.cloth_erp_api.model.product.product.ProductResponse;
import com.misstilo.cloth_erp_api.model.product.product.ProductUpdate;
import com.misstilo.cloth_erp_api.model.product.product.ProductCreate;
import com.misstilo.cloth_erp_api.model.product.product.ProductQuery;
import com.misstilo.cloth_erp_api.model.response.ResponseModel;
import com.misstilo.cloth_erp_api.service.product.ProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/product")
@Builder
public class ProductController {
    @Autowired
    private final ProductService service;

    @PostMapping("/insert")
    public ResponseModel<Integer> insert(@RequestBody @Valid ProductCreate model) {
        return ResponseModel.success(service.insert(model));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseModel<Integer> delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return ResponseModel.success(service.delete(id));
    }

    @PutMapping("/update")
    public ResponseModel<Integer> update(@RequestBody @Valid ProductUpdate model) {
        return ResponseModel.success(service.update(model));
    }

    @GetMapping("/select")
    public ResponseModel<List<ProductResponse>> select(@Valid ProductQuery model) {
        return ResponseModel.success(service.select(model));
    }
}
