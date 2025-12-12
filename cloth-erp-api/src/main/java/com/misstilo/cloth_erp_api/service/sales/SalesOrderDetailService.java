package com.misstilo.cloth_erp_api.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.sales.salesOrderDetail.SalesOrderDetailMapper;
import com.misstilo.cloth_erp_api.model.sales.salesOrderDetail.SalesOrderDetailCreate;
import com.misstilo.cloth_erp_api.model.sales.salesOrderDetail.SalesOrderDetailResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrderDetail.SalesOrderDetailUpdate;

import lombok.Builder;

@Service
@Builder
public class SalesOrderDetailService {
    @Autowired
    private final SalesOrderDetailMapper mapper;

    @Transactional
    public Integer insert(SalesOrderDetailCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(SalesOrderDetailUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<SalesOrderDetailResponse> select(Integer salesOrderId) {
        return mapper.select(salesOrderId);
    }
}
