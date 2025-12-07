package com.misstilo.cloth_erp_api.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.TagModel;
import com.misstilo.cloth_erp_api.model.product.TagQueryModel;

@Mapper
public interface TagMapper {
    Integer insert(TagModel model);

    Integer delete(Integer id);

    Integer update(TagModel model);

    List<TagModel> select(TagQueryModel model);
}
