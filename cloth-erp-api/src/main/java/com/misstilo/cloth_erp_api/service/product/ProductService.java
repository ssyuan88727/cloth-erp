package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.model.product.product.ProductResponse;
import com.misstilo.cloth_erp_api.model.product.product.ProductUpdate;
import com.misstilo.cloth_erp_api.mapper.product.product.ProductMapper;
import com.misstilo.cloth_erp_api.model.product.product.ProductCreate;
import com.misstilo.cloth_erp_api.model.product.product.ProductQuery;

import lombok.Builder;

@Service
@Builder
@Transactional
public class ProductService {
    @Autowired
    private final ProductMapper productMapper;
    @Autowired
    private final ProductTagRelService productTagRelService;

    public Integer insert(ProductCreate model) {
        productMapper.insert(model);
        productTagRelService.batchInsert(1, model.getTag());
        return 1;
    }

    public Integer delete(Integer id) {
        productTagRelService.deleteByProductId(id);
        return productMapper.delete(id);
    }

    public Integer update(ProductUpdate model) {
        productTagRelService.deleteByProductId(model.getId());
        productTagRelService.batchInsert(model.getId(), model.getTag());
        return productMapper.update(model);
    }

    public List<ProductResponse> select(ProductQuery model) {
        return productMapper.select(model);
    }
}
