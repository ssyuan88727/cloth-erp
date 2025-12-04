package com.misstilo.cloth_erp_api.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.base.StoreTypeMapper;
import com.misstilo.cloth_erp_api.model.base.StoreTypeModel;
import com.misstilo.cloth_erp_api.model.base.StoreTypeQueryModel;

import lombok.Builder;

@Service
@Builder
public class StoreTypeService {
    @Autowired
    private final StoreTypeMapper mapper;

    public Integer insert(StoreTypeModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(StoreTypeModel model) {
        return mapper.update(model);
    }

    public List<StoreTypeModel> select(StoreTypeQueryModel model) {
        return mapper.select(model);
    }
}
