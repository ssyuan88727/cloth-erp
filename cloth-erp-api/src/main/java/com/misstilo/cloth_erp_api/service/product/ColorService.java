package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.product.color.ColorMapper;
import com.misstilo.cloth_erp_api.model.product.color.ColorResponse;
import com.misstilo.cloth_erp_api.model.product.color.ColorUpdate;
import com.misstilo.cloth_erp_api.model.product.color.ColorCreate;
import com.misstilo.cloth_erp_api.model.product.color.ColorQuery;

import lombok.Builder;

@Service
@Builder
public class ColorService {
    @Autowired
    private final ColorMapper mapper;

    @Transactional
    public Integer insert(ColorCreate model) {
        model.setCode(model.getCode().toUpperCase());
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(ColorUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<ColorResponse> select(ColorQuery model) {
        model.setCode(model.getCode().toUpperCase());
        return mapper.select(model);
    }
}
