package com.misstilo.cloth_erp_api.mapper.purchase;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.PurchaseOrderModel;

@Mapper
public interface PurchaseOrderDetailMapper {
  Integer insert(PurchaseOrderModel model);

  Integer delete(Integer id);

  Integer update(PurchaseOrderModel model);

  List<PurchaseOrderModel> select(Integer purchaseOrderId);
}
