package com.misstilo.cloth_erp_api.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.misstilo.cloth_erp_api.model.base.StoreTypeModel;
import com.misstilo.cloth_erp_api.model.base.StoreTypeQueryModel;

@Mapper
public interface StoreTypeMapper {
    @InsertProvider(type = StoreTypeProvider.class, method = "insert")
    Integer insert(StoreTypeModel model);

    @DeleteProvider(type = StoreTypeProvider.class, method = "delete")
    Integer delete(Integer id);

    @UpdateProvider(type = StoreTypeProvider.class, method = "update")
    Integer update(StoreTypeModel model);

    @SelectProvider(type = StoreTypeProvider.class, method = "select")
    List<StoreTypeModel> select(StoreTypeQueryModel model);
}
