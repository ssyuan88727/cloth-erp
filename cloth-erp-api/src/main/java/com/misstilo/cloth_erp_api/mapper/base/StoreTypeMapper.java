package com.misstilo.cloth_erp_api.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.base.StoreTypeModel;
import com.misstilo.cloth_erp_api.model.base.StoreTypeQueryModel;

@Mapper
public interface StoreTypeMapper {
    Integer insert(StoreTypeModel model);

    Integer delete(Integer id);

    Integer update(StoreTypeModel model);

    List<StoreTypeModel> select(StoreTypeQueryModel model);
}
