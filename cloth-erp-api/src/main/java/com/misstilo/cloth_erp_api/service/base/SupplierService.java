package com.misstilo.cloth_erp_api.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.base.SupplierMapper;
import com.misstilo.cloth_erp_api.model.base.SupplierModel;
import com.misstilo.cloth_erp_api.model.base.SupplierQueryModel;

import lombok.Builder;

@Service
@Builder
public class SupplierService {
    @Autowired
    private final SupplierMapper mapper;

    public Integer insert(SupplierModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(SupplierModel model) {
        return mapper.update(model);
    }

    public List<SupplierModel> select(SupplierQueryModel model) {
        return mapper.select(model);
    }
}
