package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.purchase.purchaseOrder.PurchaseOrderMapper;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrder.PurchaseOrderCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrder.PurchaseOrderQuery;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrder.PurchaseOrderResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseOrder.PurchaseOrderUpdate;

import lombok.Builder;

@Service
@Builder
public class PurchaseOrderService {
    @Autowired
    private final PurchaseOrderMapper mapper;

    public Integer insert(PurchaseOrderCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(PurchaseOrderUpdate model) {
        return mapper.update(model);
    }

    public List<PurchaseOrderResponse> select(PurchaseOrderQuery model) {
        return mapper.select(model);
    }
}
