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

import com.misstilo.cloth_erp_api.model.base.ReturnReasonModel;
import com.misstilo.cloth_erp_api.model.base.ReturnReasonQueryModel;
import com.misstilo.cloth_erp_api.model.response.ResponseModel;
import com.misstilo.cloth_erp_api.service.base.ReturnReasonService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@RestController
@RequestMapping("/return-reason")
@Builder
public class ReturnReasonController {
    @Autowired
    private final ReturnReasonService service;

    @PostMapping("/insert")
    public ResponseModel<Integer> insert(@RequestBody @Valid ReturnReasonModel model) {
        return ResponseModel.success(service.insert(model));
    }

    @DeleteMapping("/delete")
    public ResponseModel<Integer> delete(@PathVariable @NotNull Integer id) {
        return ResponseModel.success(service.delete(id));
    }

    @PutMapping("/update")
    public ResponseModel<Integer> update(@RequestBody @Valid ReturnReasonModel model) {
        return ResponseModel.success(service.update(model));
    }

    @GetMapping("/select")
    public ResponseModel<List<ReturnReasonModel>> select(@Valid ReturnReasonQueryModel model) {
        return ResponseModel.success(service.select(model));
    }
}
