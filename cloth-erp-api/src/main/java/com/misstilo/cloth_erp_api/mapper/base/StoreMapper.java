package com.misstilo.cloth_erp_api.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.base.StoreModel;
import com.misstilo.cloth_erp_api.model.base.StoreQueryModel;

@Mapper
public interface StoreMapper {
    Integer insert(StoreModel model);

    Integer delete(Integer id);

    Integer update(StoreModel model);

    List<StoreModel> select(StoreQueryModel model);
}
