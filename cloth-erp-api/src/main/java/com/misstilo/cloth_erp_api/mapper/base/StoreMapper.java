package com.misstilo.cloth_erp_api.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.misstilo.cloth_erp_api.model.base.StoreModel;
import com.misstilo.cloth_erp_api.model.base.StoreQueryModel;

@Mapper
public interface StoreMapper {
    @InsertProvider(type = StoreProvider.class, method = "insert")
    Integer insert(StoreModel model);

    @DeleteProvider(type = StoreProvider.class, method = "delete")
    Integer delete(Integer id);

    @UpdateProvider(type = StoreProvider.class, method = "update")
    Integer update(StoreModel model);

    @Results(id = "StoreResultMap", value = {
            @Result(column = "Id", property = "id", javaType = Integer.class, id = true),
            @Result(column = "Code", property = "code", javaType = String.class),
            @Result(column = "Name", property = "name", javaType = String.class),
            @Result(column = "StoreTypeId", property = "storeTypeId", javaType = Integer.class),
            @Result(column = "StoreTypeName", property = "storeTypeName", javaType = String.class),
            @Result(column = "IsActive", property = "isActive", javaType = Boolean.class),
            @Result(column = "CreateAt", property = "createAt", javaType = String.class),
            @Result(column = "UpdateAt", property = "updateAt", javaType = String.class)

    })
    @SelectProvider(type = StoreProvider.class, method = "select")
    List<StoreModel> select(StoreQueryModel model);
}
