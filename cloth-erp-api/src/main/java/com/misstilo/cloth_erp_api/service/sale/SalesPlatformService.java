package com.misstilo.cloth_erp_api.service.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.sale.SalesPlatformMapper;
import com.misstilo.cloth_erp_api.model.sale.SalesPlatformModel;
import com.misstilo.cloth_erp_api.model.sale.SalesPlatformQueryModel;

import lombok.Builder;

@Service
@Builder
public class SalesPlatformService {
    @Autowired
    private final SalesPlatformMapper mapper;

    public Integer insert(SalesPlatformModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(SalesPlatformModel model) {
        return mapper.update(model);
    }

    public List<SalesPlatformModel> select(SalesPlatformQueryModel model) {
        return mapper.select(model);
    }
}
