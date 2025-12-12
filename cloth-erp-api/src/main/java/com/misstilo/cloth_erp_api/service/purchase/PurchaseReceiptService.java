package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.purchase.purchaseReceipt.PurchaseReceiptMapper;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt.PurchaseReceiptCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt.PurchaseReceiptQuery;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt.PurchaseReceiptResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReceipt.PurchaseReceiptUpdate;

import lombok.Builder;

@Service
@Builder
public class PurchaseReceiptService {
    @Autowired
    private final PurchaseReceiptMapper mapper;

    @Transactional
    public Integer insert(PurchaseReceiptCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(PurchaseReceiptUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<PurchaseReceiptResponse> select(PurchaseReceiptQuery model) {
        return mapper.select(model);
    }
}
