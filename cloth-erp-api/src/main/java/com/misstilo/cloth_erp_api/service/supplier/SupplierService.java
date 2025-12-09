package com.misstilo.cloth_erp_api.service.supplier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Integer insert(SupplierCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(SupplierUpdate model) {
        return mapper.update(model);
    }

    public List<SupplierResponse> select(SupplierQuery model) {
        return mapper.select(model);
    }
}
