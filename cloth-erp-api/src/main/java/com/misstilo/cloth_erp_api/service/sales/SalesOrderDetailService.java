package com.misstilo.cloth_erp_api.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Integer insert(SalesOrderDetailCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(SalesOrderDetailUpdate model) {
        return mapper.update(model);
    }

    public List<SalesOrderDetailResponse> select(Integer salesOrderId) {
        return mapper.select(salesOrderId);
    }
}
