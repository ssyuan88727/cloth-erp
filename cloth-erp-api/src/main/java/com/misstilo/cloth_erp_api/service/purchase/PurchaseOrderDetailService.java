package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.purchase.PurchaseOrderDetailMapper;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseOrderModel;

import lombok.Builder;

@Service
@Builder
public class PurchaseOrderDetailService {
  @Autowired
  private final PurchaseOrderDetailMapper mapper;

  public Integer insert(PurchaseOrderModel model) {
    return mapper.insert(model);
  }

  public Integer delete(Integer id) {
    return mapper.delete(id);
  }

  public Integer update(PurchaseOrderModel model) {
    return mapper.update(model);
  }

  public List<PurchaseOrderModel> select(Integer purchaseOrderId) {
    return mapper.select(purchaseOrderId);
  }
}
