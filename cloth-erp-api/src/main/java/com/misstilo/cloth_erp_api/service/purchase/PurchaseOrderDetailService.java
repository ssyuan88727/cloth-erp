package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Integer insert(PurchaseOrderDetailCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(PurchaseOrderDetailUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<PurchaseOrderDetailResponse> select(Integer purchaseOrderId) {
        return mapper.select(purchaseOrderId);
    }
}
