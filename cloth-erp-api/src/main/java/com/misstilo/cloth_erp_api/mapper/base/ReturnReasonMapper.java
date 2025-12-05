package com.misstilo.cloth_erp_api.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.misstilo.cloth_erp_api.model.base.ReturnReasonModel;
import com.misstilo.cloth_erp_api.model.base.ReturnReasonQueryModel;

@Mapper
public interface ReturnReasonMapper {
    @InsertProvider(type = ReturnReasonProvider.class, method = "insert")
    Integer insert(ReturnReasonModel model);

    @DeleteProvider(type = ReturnReasonProvider.class, method = "delete")
    Integer delete(Integer id);

    @UpdateProvider(type = ReturnReasonProvider.class, method = "update")
    Integer update(ReturnReasonModel model);

    @Results(id = "ReturnReasonResultMap", value = {
            @Result(column = "Id", property = "id", javaType = Integer.class, id = true),
            @Result(column = "Reason", property = "reason", javaType = String.class)
    })
    @SelectProvider(type = ReturnReasonProvider.class, method = "select")
    List<ReturnReasonModel> select(ReturnReasonQueryModel model);
}
