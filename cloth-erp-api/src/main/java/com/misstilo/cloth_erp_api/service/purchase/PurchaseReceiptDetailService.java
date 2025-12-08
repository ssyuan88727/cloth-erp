package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.purchase.PurchaseReceiptDetailMapper;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseReceiptDetailModel;

import lombok.Builder;

@Service
@Builder
public class PurchaseReceiptDetailService {
    @Autowired
    private final PurchaseReceiptDetailMapper mapper;

    public Integer insert(PurchaseReceiptDetailModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(PurchaseReceiptDetailModel model) {
        return mapper.update(model);
    }

    public List<PurchaseReceiptDetailModel> select(Integer purchaseReceiptId) {
        return mapper.select(purchaseReceiptId);
    }
}
