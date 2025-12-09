package com.misstilo.cloth_erp_api.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.store.storeType.StoreTypeMapper;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeResponse;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeUpdate;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeCreate;
import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeQuery;

import lombok.Builder;

@Service
@Builder
public class StoreTypeService {
    @Autowired
    private final StoreTypeMapper mapper;

    public Integer insert(StoreTypeCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(StoreTypeUpdate model) {
        return mapper.update(model);
    }

    public List<StoreTypeResponse> select(StoreTypeQuery model) {
        return mapper.select(model);
    }
}
