package com.misstilo.cloth_erp_api.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.sales.salesOrder.SalesOrderMapper;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderCreate;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderQuery;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderUpdate;

import lombok.Builder;

@Service
@Builder
public class SalesOrderService {
    @Autowired
    private final SalesOrderMapper mapper;

    public Integer insert(SalesOrderCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(SalesOrderUpdate model) {
        return mapper.update(model);
    }

    public List<SalesOrderResponse> select(SalesOrderQuery model) {
        return mapper.select(model);
    }
}
