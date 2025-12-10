package com.misstilo.cloth_erp_api.mapper.product.productTagRel;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.productTagRel.ProductTagRelCreate;

@Mapper
public interface ProductTagRelMapper {
    Integer batchInsert(List<ProductTagRelCreate> list);

    Integer deleteByProductId(Integer productId);
}
