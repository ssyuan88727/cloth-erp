package com.misstilo.cloth_erp_api.mapper.purchase.purchaseOrder;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.purchaseOrder.PurchaseOrderCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrder.PurchaseOrderQuery;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrder.PurchaseOrderResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrder.PurchaseOrderUpdate;

@Mapper
public interface PurchaseOrderMapper {
    Integer insert(PurchaseOrderCreate model);

    Integer update(PurchaseOrderUpdate model);

    Integer delete(Integer id);

    List<PurchaseOrderResponse> select(PurchaseOrderQuery model);
}
