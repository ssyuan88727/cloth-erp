package com.misstilo.cloth_erp_api.mapper.product.tag;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.product.tag.TagResponse;
import com.misstilo.cloth_erp_api.model.product.tag.TagUpdate;
import com.misstilo.cloth_erp_api.model.product.tag.TagCreate;
import com.misstilo.cloth_erp_api.model.product.tag.TagQuery;

@Mapper
public interface TagMapper {
    Integer insert(TagCreate model);

    Integer delete(Integer id);

    Integer update(TagUpdate model);

    List<TagResponse> select(TagQuery model);
}
