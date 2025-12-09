package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.product.tag.TagMapper;
import com.misstilo.cloth_erp_api.model.product.tag.TagResponse;
import com.misstilo.cloth_erp_api.model.product.tag.TagUpdate;
import com.misstilo.cloth_erp_api.model.product.tag.TagCreate;
import com.misstilo.cloth_erp_api.model.product.tag.TagQuery;

import lombok.Builder;

@Service
@Builder
public class TagService {
    @Autowired
    private final TagMapper mapper;

    public Integer insert(TagCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(TagUpdate model) {
        return mapper.update(model);
    }

    public List<TagResponse> select(TagQuery model) {
        return mapper.select(model);
    }
}
