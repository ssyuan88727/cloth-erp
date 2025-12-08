package com.misstilo.cloth_erp_api.mapper.sale;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.sale.SalesPlatformModel;
import com.misstilo.cloth_erp_api.model.sale.SalesPlatformQueryModel;

@Mapper
public interface SalesPlatformMapper {
    Integer insert(SalesPlatformModel model);

    Integer delete(Integer id);

    Integer update(SalesPlatformModel model);

    List<SalesPlatformModel> select(SalesPlatformQueryModel model);
}
