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

import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuCreate;
import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuResponse;
import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuUpdate;
import com.misstilo.cloth_erp_api.model.response.ResponseModel;
import com.misstilo.cloth_erp_api.service.product.ProductSkuService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/product-sku")
@Builder
public class ProductSkuController {
  @Autowired
  private final ProductSkuService service;

  @PostMapping("/insert")
  public ResponseModel<Integer> insert(@RequestBody @Valid ProductSkuCreate model) {
    return ResponseModel.success(service.insert(model));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseModel<Integer> delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
    return ResponseModel.success(service.delete(id));
  }

  @PutMapping("/update")
  public ResponseModel<Integer> update(@RequestBody @Valid ProductSkuUpdate model) {
    return ResponseModel.success(service.update(model));
  }

  @GetMapping("/select/{productId}")
  public ResponseModel<List<ProductSkuResponse>> select(@PathVariable @NotNull(message = "Select: ProductId is required.") Integer productId) {
    return ResponseModel.success(service.select(productId));
  }
}
