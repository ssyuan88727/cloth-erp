package com.misstilo.cloth_erp_api.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.base.SupplierModel;
import com.misstilo.cloth_erp_api.model.base.SupplierQueryModel;

@Mapper
public interface SupplierMapper {
    Integer insert(SupplierModel model);

    Integer delete(Integer id);

    Integer update(SupplierModel model);

    List<SupplierModel> select(SupplierQueryModel model);
}
