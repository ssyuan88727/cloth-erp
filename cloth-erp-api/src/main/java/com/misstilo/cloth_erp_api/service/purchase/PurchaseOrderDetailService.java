package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.purchase.purchaseOrderDetail.PurchaseOrderDetailMapper;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail.PurchaseOrderDetailCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail.PurchaseOrderDetailResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrderDetail.PurchaseOrderDetailUpdate;

import lombok.Builder;

@Service
@Builder
public class PurchaseOrderDetailService {
    @Autowired
    private final PurchaseOrderDetailMapper mapper;

    public Integer insert(PurchaseOrderDetailCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(PurchaseOrderDetailUpdate model) {
        return mapper.update(model);
    }

    public List<PurchaseOrderDetailResponse> select(Integer purchaseOrderId) {
        return mapper.select(purchaseOrderId);
    }
}
