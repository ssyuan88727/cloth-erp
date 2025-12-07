package com.misstilo.cloth_erp_api.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.base.ReturnReasonModel;
import com.misstilo.cloth_erp_api.model.base.ReturnReasonQueryModel;

@Mapper
public interface ReturnReasonMapper {
    Integer insert(ReturnReasonModel model);

    Integer delete(Integer id);

    Integer update(ReturnReasonModel model);

    List<ReturnReasonModel> select(ReturnReasonQueryModel model);
}
