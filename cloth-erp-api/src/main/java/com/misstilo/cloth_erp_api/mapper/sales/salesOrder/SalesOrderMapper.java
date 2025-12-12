package com.misstilo.cloth_erp_api.mapper.sales.salesOrder;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderCreate;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderQuery;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrder.SalesOrderUpdate;

@Mapper
public interface SalesOrderMapper {
    Integer insert(SalesOrderCreate model);

    Integer delete(Integer id);

    Integer update(SalesOrderUpdate model);

    List<SalesOrderResponse> select(SalesOrderQuery model);
}
