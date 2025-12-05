package com.misstilo.cloth_erp_api.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.misstilo.cloth_erp_api.model.base.SupplierModel;
import com.misstilo.cloth_erp_api.model.base.SupplierQueryModel;

@Mapper
public interface SupplierMapper {
    @InsertProvider(type = SupplierProvider.class, method = "insert")
    Integer insert(SupplierModel model);

    @DeleteProvider(type = SupplierProvider.class, method = "delete")
    Integer delete(Integer id);

    @UpdateProvider(type = SupplierProvider.class, method = "update")
    Integer update(SupplierModel model);

    @Results(id = "SupplierResultMap", value = {
            @Result(column = "Id", property = "id", javaType = Integer.class, id = true),
            @Result(column = "Code", property = "code", javaType = String.class),
            @Result(column = "Name", property = "name", javaType = String.class),
            @Result(column = "ContactName", property = "contactName", javaType = String.class),
            @Result(column = "ContactPhone", property = "contactPhone", javaType = String.class),
            @Result(column = "Address", property = "address", javaType = String.class),
            @Result(column = "IsActive", property = "isActive", javaType = Boolean.class),
            @Result(column = "CreateAt", property = "createAt", javaType = String.class),
            @Result(column = "UpdateAt", property = "updateAt", javaType = String.class)
    })
    @SelectProvider(type = SupplierProvider.class, method = "select")
    List<SupplierModel> select(SupplierQueryModel model);
}
