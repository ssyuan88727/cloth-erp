package com.misstilo.cloth_erp_api.mapper.store.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.store.store.StoreResponse;
import com.misstilo.cloth_erp_api.model.store.store.StoreUpdate;
import com.misstilo.cloth_erp_api.model.store.store.StoreCreate;
import com.misstilo.cloth_erp_api.model.store.store.StoreQuery;

@Mapper
public interface StoreMapper {
    Integer insert(StoreCreate model);

    Integer delete(Integer id);

    Integer update(StoreUpdate model);

    List<StoreResponse> select(StoreQuery model);
}
