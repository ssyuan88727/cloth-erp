package com.misstilo.cloth_erp_api.mapper.purchase;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.PurchaseReturnDetailModel;

@Mapper
public interface PurchaseReturnDetailMapper {
    Integer insert(PurchaseReturnDetailModel model);

    Integer delete(Integer id);

    Integer update(PurchaseReturnDetailModel model);

    List<PurchaseReturnDetailModel> select(Integer purchaseReturnId);
}
