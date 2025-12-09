package com.misstilo.cloth_erp_api.mapper.store.storeType;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeResponse;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeUpdate;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeCreate;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeQuery;

@Mapper
public interface StoreTypeMapper {
    Integer insert(StoreTypeCreate model);

    Integer delete(Integer id);

    Integer update(StoreTypeUpdate model);

    List<StoreTypeResponse> select(StoreTypeQuery model);
}
