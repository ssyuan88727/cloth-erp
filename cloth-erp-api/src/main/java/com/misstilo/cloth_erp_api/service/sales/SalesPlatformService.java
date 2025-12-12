package com.misstilo.cloth_erp_api.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.sales.salesPlatform.SalesPlatformMapper;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformCreate;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformQuery;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformResponse;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformUpdate;

import lombok.Builder;

@Service
@Builder
public class SalesPlatformService {
    @Autowired
    private final SalesPlatformMapper mapper;

    @Transactional
    public Integer insert(SalesPlatformCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(SalesPlatformUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<SalesPlatformResponse> select(SalesPlatformQuery model) {
        return mapper.select(model);
    }
}
