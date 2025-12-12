package com.misstilo.cloth_erp_api.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.model.store.store.StoreResponse;
import com.misstilo.cloth_erp_api.model.store.store.StoreUpdate;
import com.misstilo.cloth_erp_api.model.store.store.StoreCreate;
import com.misstilo.cloth_erp_api.mapper.store.store.StoreMapper;
import com.misstilo.cloth_erp_api.model.store.store.StoreQuery;

import lombok.Builder;

@Service
@Builder
public class StoreService {
    @Autowired
    private final StoreMapper mapper;

    @Transactional
    public Integer insert(StoreCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(StoreUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<StoreResponse> select(StoreQuery model) {
        return mapper.select(model);
    }
}
