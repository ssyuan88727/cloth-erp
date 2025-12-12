package com.misstilo.cloth_erp_api.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.sales.salesReturnDetail.SalesReturnDetailMapper;
import com.misstilo.cloth_erp_api.model.sales.salesReturnDetail.SalesReturnDetailCreate;
import com.misstilo.cloth_erp_api.model.sales.salesReturnDetail.SalesReturnDetailResponse;
import com.misstilo.cloth_erp_api.model.sales.salesReturnDetail.SalesReturnDetailUpdate;

import lombok.Builder;

@Service
@Builder
public class SalesReturnDetailService {
    @Autowired
    private final SalesReturnDetailMapper mapper;

    public Integer insert(SalesReturnDetailCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(SalesReturnDetailUpdate model) {
        return mapper.update(model);
    }

    public List<SalesReturnDetailResponse> select(Integer salesReturnId) {
        return mapper.select(salesReturnId);
    }
}
