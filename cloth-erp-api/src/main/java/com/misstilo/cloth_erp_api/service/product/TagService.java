package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.product.TagMapper;
import com.misstilo.cloth_erp_api.model.product.TagModel;
import com.misstilo.cloth_erp_api.model.product.TagQueryModel;

import lombok.Builder;

@Service
@Builder
public class TagService {
    @Autowired
    private final TagMapper mapper;

    public Integer insert(TagModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(TagModel model) {
        return mapper.update(model);
    }

    public List<TagModel> select(TagQueryModel model) {
        return mapper.select(model);
    }
}
