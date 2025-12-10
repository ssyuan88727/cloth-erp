package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.product.size.SizeMapper;
import com.misstilo.cloth_erp_api.model.product.size.SizeResponse;
import com.misstilo.cloth_erp_api.model.product.size.SizeUpdate;
import com.misstilo.cloth_erp_api.model.product.size.SizeCreate;
import com.misstilo.cloth_erp_api.model.product.size.SizeQuery;

import lombok.Builder;

@Service
@Builder
public class SizeService {
    @Autowired
    private final SizeMapper mapper;

    @Transactional
    public Integer insert(SizeCreate model) {
        model.setCode(model.getCode().toUpperCase());
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(SizeUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<SizeResponse> select(SizeQuery model) {
        model.setCode(model.getCode().toUpperCase());
        return mapper.select(model);
    }
}
