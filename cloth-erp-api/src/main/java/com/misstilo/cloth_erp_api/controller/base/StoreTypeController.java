package com.misstilo.cloth_erp_api.controller.base;

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

import com.misstilo.cloth_erp_api.model.base.StoreTypeModel;
import com.misstilo.cloth_erp_api.model.base.StoreTypeQueryModel;
import com.misstilo.cloth_erp_api.service.base.StoreTypeService;

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
    public Integer insert(@RequestBody @Valid StoreTypeModel model) {
        return service.insert(model);
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable @NotNull Integer id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody @Valid StoreTypeModel model) {
        return service.update(model);
    }

    @GetMapping("/select")
    public List<StoreTypeModel> select(StoreTypeQueryModel model) {
        return service.select(model);
    }
}
