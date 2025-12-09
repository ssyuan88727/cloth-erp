package com.misstilo.cloth_erp_api.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.model.store.store.StoreResponse;
import com.misstilo.cloth_erp_api.model.store.store.StoreUpdate;
import com.misstilo.cloth_erp_api.model.store.store.StroeCreate;
import com.misstilo.cloth_erp_api.mapper.store.store.StoreMapper;
import com.misstilo.cloth_erp_api.model.store.store.StoreQuery;

import lombok.Builder;

@Service
@Builder
public class StoreService {
    @Autowired
    private final StoreMapper mapper;

    public Integer insert(StroeCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(StoreUpdate model) {
        return mapper.update(model);
    }

    public List<StoreResponse> select(StoreQuery model) {
        return mapper.select(model);
    }
}
