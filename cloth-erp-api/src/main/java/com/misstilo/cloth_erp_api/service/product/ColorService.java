package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.product.ColorMapper;
import com.misstilo.cloth_erp_api.model.product.ColorModel;
import com.misstilo.cloth_erp_api.model.product.ColorQueryModel;

import lombok.Builder;

@Service
@Builder
public class ColorService {
    @Autowired
    private final ColorMapper mapper;

    public Integer insert(ColorModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(ColorModel model) {
        return mapper.update(model);
    }

    public List<ColorModel> select(ColorQueryModel model) {
        return mapper.select(model);
    }
}
