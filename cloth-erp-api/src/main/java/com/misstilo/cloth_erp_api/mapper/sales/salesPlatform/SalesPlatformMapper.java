package com.misstilo.cloth_erp_api.mapper.sales.salesPlatform;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformCreate;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformQuery;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformResponse;
import com.misstilo.cloth_erp_api.model.sales.salesPlatform.SalesPlatformUpdate;

@Mapper
public interface SalesPlatformMapper {
    Integer insert(SalesPlatformCreate model);

    Integer delete(Integer id);

    Integer update(SalesPlatformUpdate model);

    List<SalesPlatformResponse> select(SalesPlatformQuery model);
}
