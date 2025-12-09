package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Integer insert(ColorCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(ColorUpdate model) {
        return mapper.update(model);
    }

    public List<ColorResponse> select(ColorQuery model) {
        return mapper.select(model);
    }
}
