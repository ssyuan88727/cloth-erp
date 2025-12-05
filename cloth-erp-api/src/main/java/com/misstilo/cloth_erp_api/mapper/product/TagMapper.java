package com.misstilo.cloth_erp_api.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.misstilo.cloth_erp_api.model.product.TagModel;
import com.misstilo.cloth_erp_api.model.product.TagQueryModel;

@Mapper
public interface TagMapper {
    @InsertProvider(type = TagProvider.class, method = "insert")
    Integer insert(TagModel model);

    @DeleteProvider(type = TagProvider.class, method = "delete")
    Integer delete(Integer id);

    @UpdateProvider(type = TagProvider.class, method = "update")
    Integer update(TagModel model);

    @Results(id = "TagResultMap", value = {
            @Result(column = "Id", property = "id", javaType = Integer.class, id = true),
            @Result(column = "Name", property = "name", javaType = String.class)
    })
    @SelectProvider(type = TagProvider.class, method = "select")
    List<TagModel> select(TagQueryModel model);
}
