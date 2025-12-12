package com.misstilo.cloth_erp_api.mapper.sales.salesOrderDetail;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.sales.salesOrderDetail.SalesOrderDetailCreate;
import com.misstilo.cloth_erp_api.model.sales.salesOrderDetail.SalesOrderDetailResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrderDetail.SalesOrderDetailUpdate;

@Mapper
public interface SalesOrderDetailMapper {
    Integer insert(SalesOrderDetailCreate model);

    Integer delete(Integer id);

    Integer update(SalesOrderDetailUpdate model);

    List<SalesOrderDetailResponse> select(Integer salesOrderId);
}
