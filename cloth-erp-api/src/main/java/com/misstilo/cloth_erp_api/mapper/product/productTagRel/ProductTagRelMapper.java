package com.misstilo.cloth_erp_api.mapper.product.productTagRel;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductTagRelMapper {
    Integer batchInsert(Integer productId, List<Integer> tag);

    Integer deleteByProductId(Integer productId);
}
