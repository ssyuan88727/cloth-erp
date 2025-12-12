package com.misstilo.cloth_erp_api.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Integer insert(SalesReturnCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(SalesReturnUpdate model) {
        return mapper.update(model);
    }

    public List<SalesReturnResponse> select(SalesReturnQuery model) {
        return mapper.select(model);
    }
}
