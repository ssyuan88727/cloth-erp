package com.misstilo.cloth_erp_api.mapper.purchase;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.PurchaseReturnModel;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseReturnQueryModel;

@Mapper
public interface PurchaseReturnMapper {
    Integer insert(PurchaseReturnModel model);

    Integer delete(Integer id);

    Integer update(PurchaseReturnModel model);

    List<PurchaseReturnModel> select(PurchaseReturnQueryModel model);
}
