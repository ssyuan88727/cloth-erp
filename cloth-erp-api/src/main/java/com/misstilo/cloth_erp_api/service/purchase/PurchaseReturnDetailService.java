package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.purchase.purchaseReturnDetail.PurchaseReturnDetailMapper;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturnDetail.PurchaseReturnDetailCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturnDetail.PurchaseReturnDetailResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturnDetail.PurchaseReturnDetailUpdate;

import lombok.Builder;

@Service
@Builder
public class PurchaseReturnDetailService {
    @Autowired
    private final PurchaseReturnDetailMapper mapper;

    public Integer insert(PurchaseReturnDetailCreate model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(PurchaseReturnDetailUpdate model) {
        return mapper.update(model);
    }

    public List<PurchaseReturnDetailResponse> select(Integer purchaseReturnId) {
        return mapper.select(purchaseReturnId);
    }
}
