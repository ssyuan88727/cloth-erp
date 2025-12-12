package com.misstilo.cloth_erp_api.mapper.sales.salesReturn;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.sales.salesReturn.SalesReturnCreate;
import com.misstilo.cloth_erp_api.model.sales.salesReturn.SalesReturnQuery;
import com.misstilo.cloth_erp_api.model.sales.salesReturn.SalesReturnResponse;
import com.misstilo.cloth_erp_api.model.sales.salesReturn.SalesReturnUpdate;

@Mapper
public interface SalesReturnMapper {
    Integer insert(SalesReturnCreate model);

    Integer delete(Integer id);

    Integer update(SalesReturnUpdate model);

    List<SalesReturnResponse> select(SalesReturnQuery model);
}
