package com.misstilo.cloth_erp_api.mapper.base.returnReason;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonResponse;
import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonUpdate;
import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonCreate;
import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonQuery;

@Mapper
public interface ReturnReasonMapper {
    Integer insert(ReturnReasonCreate model);

    Integer delete(Integer id);

    Integer update(ReturnReasonUpdate model);

    List<ReturnReasonResponse> select(ReturnReasonQuery model);
}
