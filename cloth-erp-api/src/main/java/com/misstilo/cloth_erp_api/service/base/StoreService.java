package com.misstilo.cloth_erp_api.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.base.StoreMapper;
import com.misstilo.cloth_erp_api.model.base.StoreModel;
import com.misstilo.cloth_erp_api.model.base.StoreQueryModel;

import lombok.Builder;

@Service
@Builder
public class StoreService {
    @Autowired
    private final StoreMapper mapper;

    public Integer insert(StoreModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(StoreModel model) {
        return mapper.update(model);
    }

    public List<StoreModel> select(StoreQueryModel model) {
        return mapper.select(model);
    }
}
