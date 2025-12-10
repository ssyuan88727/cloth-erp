package com.misstilo.cloth_erp_api.service.supplier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.supplier.supplier.SupplierMapper;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierCreate;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierQuery;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierResponse;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierUpdate;

import lombok.Builder;

@Service
@Builder
public class SupplierService {
    @Autowired
    private final SupplierMapper mapper;

    @Transactional
    public Integer insert(SupplierCreate model) {
        model.setCode(model.getCode().toUpperCase());
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(SupplierUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<SupplierResponse> select(SupplierQuery model) {
        model.setCode(model.getCode().toUpperCase());
        return mapper.select(model);
    }
}
