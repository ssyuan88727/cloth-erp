package com.misstilo.cloth_erp_api.controller.store;

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

import com.misstilo.cloth_erp_api.model.response.ResponseModel;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeResponse;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeUpdate;
import com.misstilo.cloth_erp_api.service.store.StoreTypeService;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeCreate;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeQuery;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/store-type")
@Builder
public class StoreTypeController {
    @Autowired
    private final StoreTypeService service;

    @PostMapping("/insert")
    public ResponseModel<Integer> insert(@RequestBody @Valid StoreTypeCreate model) {
        return ResponseModel.success(service.insert(model));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseModel<Integer> delete(@PathVariable @NotNull(message = "Delete: Id is required.") Integer id) {
        return ResponseModel.success(service.delete(id));
    }

    @PutMapping("/update")
    public ResponseModel<Integer> update(@RequestBody @Valid StoreTypeUpdate model) {
        return ResponseModel.success(service.update(model));
    }

    @GetMapping("/select")
    public ResponseModel<List<StoreTypeResponse>> select(@Valid StoreTypeQuery model) {
        return ResponseModel.success(service.select(model));
    }
}
