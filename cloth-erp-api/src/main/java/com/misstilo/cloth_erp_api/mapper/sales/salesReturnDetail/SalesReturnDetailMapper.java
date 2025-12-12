package com.misstilo.cloth_erp_api.mapper.sales.salesReturnDetail;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.sales.salesReturnDetail.SalesReturnDetailCreate;
import com.misstilo.cloth_erp_api.model.sales.salesReturnDetail.SalesReturnDetailResponse;
import com.misstilo.cloth_erp_api.model.sales.salesReturnDetail.SalesReturnDetailUpdate;

@Mapper
public interface SalesReturnDetailMapper {
    Integer insert(SalesReturnDetailCreate model);

    Integer delete(Integer id);

    Integer update(SalesReturnDetailUpdate model);

    List<SalesReturnDetailResponse> select(Integer salesReturnId);
}
