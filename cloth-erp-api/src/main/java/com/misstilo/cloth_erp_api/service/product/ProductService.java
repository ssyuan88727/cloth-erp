package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.product.ProductMapper;
import com.misstilo.cloth_erp_api.model.product.ProductModel;
import com.misstilo.cloth_erp_api.model.product.ProductQueryModel;

import lombok.Builder;

@Service
@Builder
public class ProductService {
    @Autowired
    private final ProductMapper mapper;

    public Integer insert(ProductModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(ProductModel model) {
        return mapper.update(model);
    }

    public List<ProductModel> select(ProductQueryModel model) {
        return mapper.select(model);
    }
}
