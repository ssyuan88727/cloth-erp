package com.misstilo.cloth_erp_api.mapper.sales.salesOrderStatus;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusResponse;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusUpdate;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusCreate;
import com.misstilo.cloth_erp_api.model.sales.salesOrderStatus.SalesOrderStatusQuery;

@Mapper
public interface SalesOrderStatusMapper {
  Integer insert(SalesOrderStatusCreate model);

  Integer delete(Integer id);

  Integer update(SalesOrderStatusUpdate model);

  List<SalesOrderStatusResponse> select(SalesOrderStatusQuery model);

  String getCodeById(Integer id);
}
