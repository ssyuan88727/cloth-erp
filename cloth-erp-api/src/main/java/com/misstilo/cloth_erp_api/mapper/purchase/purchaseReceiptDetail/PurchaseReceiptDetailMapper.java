package com.misstilo.cloth_erp_api.mapper.purchase.purchaseReceiptDetail;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.purchaseReceiptDetail.PurchaseReceiptDetailCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceiptDetail.PurchaseReceiptDetailResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceiptDetail.PurchaseReceiptDetailUpdate;

@Mapper
public interface PurchaseReceiptDetailMapper {
    Integer insert(PurchaseReceiptDetailCreate model);

    Integer delete(Integer id);

    Integer update(PurchaseReceiptDetailUpdate model);

    List<PurchaseReceiptDetailResponse> select(Integer purchaseReceiptId);
}
