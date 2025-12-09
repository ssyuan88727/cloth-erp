package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.product.size.SizeMapper;
import com.misstilo.cloth_erp_api.model.product.size.SizeModel;
import com.misstilo.cloth_erp_api.model.product.size.SizeQueryModel;

import lombok.Builder;

@Service
@Builder
public class SizeService {
    @Autowired
    private final SizeMapper mapper;

    public Integer insert(SizeModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(SizeModel model) {
        return mapper.update(model);
    }

    public List<SizeModel> select(SizeQueryModel model) {
        return mapper.select(model);
    }
}
