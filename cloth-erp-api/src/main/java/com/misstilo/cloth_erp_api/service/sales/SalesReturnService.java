package com.misstilo.cloth_erp_api.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.sales.salesReturn.SalesReturnMapper;
import com.misstilo.cloth_erp_api.model.sales.salesReturn.SalesReturnCreate;
import com.misstilo.cloth_erp_api.model.sales.salesReturn.SalesReturnQuery;
import com.misstilo.cloth_erp_api.model.sales.salesReturn.SalesReturnResponse;
import com.misstilo.cloth_erp_api.model.sales.salesReturn.SalesReturnUpdate;

import lombok.Builder;

@Service
@Builder
public class SalesReturnService {
    @Autowired
    private final SalesReturnMapper mapper;

    @Transactional
    public Integer insert(SalesReturnCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(SalesReturnUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<SalesReturnResponse> select(SalesReturnQuery model) {
        return mapper.select(model);
    }
}
