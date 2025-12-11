package com.misstilo.cloth_erp_api.mapper.purchase.purchaseOrderDetail;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail.PurchaseOrderDetailCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail.PurchaseOrderDetailResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail.PurchaseOrderDetailUpdate;

@Mapper
public interface PurchaseOrderDetailMapper {
    Integer insert(PurchaseOrderDetailCreate model);

    Integer delete(Integer id);

    Integer update(PurchaseOrderDetailUpdate model);

    List<PurchaseOrderDetailResponse> select(Integer purchaseOrderId);
}
