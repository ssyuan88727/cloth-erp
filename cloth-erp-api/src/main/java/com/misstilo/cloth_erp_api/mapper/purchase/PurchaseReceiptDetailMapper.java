package com.misstilo.cloth_erp_api.mapper.purchase;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.PurchaseReceiptDetailModel;

@Mapper
public interface PurchaseReceiptDetailMapper {
    Integer insert(PurchaseReceiptDetailModel model);

    Integer delete(Integer id);

    Integer update(PurchaseReceiptDetailModel model);

    List<PurchaseReceiptDetailModel> select(Integer purchaseReceiptId);
}
