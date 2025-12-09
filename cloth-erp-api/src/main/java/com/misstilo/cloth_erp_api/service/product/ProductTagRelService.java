package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.product.productTagRel.ProductTagRelMapper;

import lombok.Builder;

@Service
@Builder
public class ProductTagRelService {
    @Autowired
    private final ProductTagRelMapper mapper;

    public Integer batchInsert(Integer productId, List<Integer> tag) {
        return mapper.batchInsert(productId, tag);
    }

    public Integer deleteByProductId(Integer productId) {
        return mapper.deleteByProductId(productId);
    }
}
