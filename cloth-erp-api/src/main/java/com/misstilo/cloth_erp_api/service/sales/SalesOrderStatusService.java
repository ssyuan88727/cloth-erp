package com.misstilo.cloth_erp_api.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.sales.salesOrderStatus.SalesOrderStatusMapper;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusCreate;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusQuery;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusUpdate;

import lombok.Builder;

@Service
@Builder
public class SalesOrderStatusService {
    @Autowired
    private final SalesOrderStatusMapper mapper;

    @Transactional
    public Integer insert(SalesOrderStatusCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(SalesOrderStatusUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<SalesOrderStatusResponse> select(SalesOrderStatusQuery model) {
        return mapper.select(model);
    }
}
