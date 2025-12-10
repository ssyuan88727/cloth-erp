package com.misstilo.cloth_erp_api.mapper.supplier.supplier;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierCreate;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierQuery;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierResponse;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierUpdate;

@Mapper
public interface SupplierMapper {
    Integer insert(SupplierCreate model);

    Integer delete(Integer id);

    Integer update(SupplierUpdate model);

    List<SupplierResponse> select(SupplierQuery model);

    String getCodeById(Integer id);
}
