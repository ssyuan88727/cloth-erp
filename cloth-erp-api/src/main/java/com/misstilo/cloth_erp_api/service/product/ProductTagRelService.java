package com.misstilo.cloth_erp_api.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.misstilo.cloth_erp_api.mapper.product.productTagRel.ProductTagRelMapper;
import com.misstilo.cloth_erp_api.model.product.productTagRel.ProductTagRelCreate;

import lombok.Builder;

@Service
@Builder
public class ProductTagRelService {
    @Autowired
    private final ProductTagRelMapper mapper;

    private List<ProductTagRelCreate> parseData(Integer productId, List<Integer> tag) {
        List<ProductTagRelCreate> list = new ArrayList<ProductTagRelCreate>();
        for (Integer t : tag) {
            list.add(ProductTagRelCreate.builder().productId(productId).tagId(t).build());
        }
        return list;
    }

    @Transactional
    public Integer batchInsert(Integer productId, List<Integer> tag) {
        if (!CollectionUtils.isEmpty(tag)) {
            return mapper.batchInsert(this.parseData(productId, tag));
        }
        return 0;
    }

    @Transactional
    public Integer deleteByProductId(Integer productId) {
        return mapper.deleteByProductId(productId);
    }

    @Transactional
    public Integer updateByProductId(Integer productId, List<Integer> tag) {
        mapper.deleteByProductId(productId);
        return this.batchInsert(productId, tag);
    }
}
