package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.purchase.PurchaseReturnDetailMapper;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseReturnDetailModel;

import lombok.Builder;

@Service
@Builder
public class PurchaseReturnDetailService {
    @Autowired
    private final PurchaseReturnDetailMapper mapper;

    public Integer insert(PurchaseReturnDetailModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(PurchaseReturnDetailModel model) {
        return mapper.update(model);
    }

    public List<PurchaseReturnDetailModel> select(Integer purchaseReturnId) {
        return mapper.select(purchaseReturnId);
    }
}
