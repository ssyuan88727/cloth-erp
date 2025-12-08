package com.misstilo.cloth_erp_api.mapper.purchase;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.PurchaseReceiptModel;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseReceiptQueryModel;

@Mapper
public interface PurchaseReceiptMapper {
    Integer insert(PurchaseReceiptModel model);

    Integer delete(Integer id);

    Integer update(PurchaseReceiptModel model);

    List<PurchaseReceiptModel> select(PurchaseReceiptQueryModel model);
}
