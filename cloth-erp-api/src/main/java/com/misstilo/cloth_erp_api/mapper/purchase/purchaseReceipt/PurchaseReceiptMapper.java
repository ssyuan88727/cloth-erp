package com.misstilo.cloth_erp_api.mapper.purchase.purchaseReceipt;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt.PurchaseReceiptCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt.PurchaseReceiptQuery;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt.PurchaseReceiptResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt.PurchaseReceiptUpdate;

@Mapper
public interface PurchaseReceiptMapper {
    Integer insert(PurchaseReceiptCreate model);

    Integer delete(Integer id);

    Integer update(PurchaseReceiptUpdate model);

    List<PurchaseReceiptResponse> select(PurchaseReceiptQuery model);
}
