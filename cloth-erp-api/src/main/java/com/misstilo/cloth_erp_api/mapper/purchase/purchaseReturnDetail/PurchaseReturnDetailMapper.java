package com.misstilo.cloth_erp_api.mapper.purchase.purchaseReturnDetail;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.purchaseReturnDetail.PurchaseReturnDetailCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturnDetail.PurchaseReturnDetailResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturnDetail.PurchaseReturnDetailUpdate;

@Mapper
public interface PurchaseReturnDetailMapper {
    Integer insert(PurchaseReturnDetailCreate model);

    Integer delete(Integer id);

    Integer update(PurchaseReturnDetailUpdate model);

    List<PurchaseReturnDetailResponse> select(Integer purchaseReturnId);
}
