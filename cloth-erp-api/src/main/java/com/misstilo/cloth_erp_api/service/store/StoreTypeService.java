package com.misstilo.cloth_erp_api.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Integer insert(StoreTypeCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(StoreTypeUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<StoreTypeResponse> select(StoreTypeQuery model) {
        return mapper.select(model);
    }
}
