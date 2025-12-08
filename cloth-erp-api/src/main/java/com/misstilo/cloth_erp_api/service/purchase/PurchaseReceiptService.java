package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.purchase.PurchaseReceiptMapper;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseReceiptModel;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseReceiptQueryModel;

import lombok.Builder;

@Service
@Builder
public class PurchaseReceiptService {
    @Autowired
    private final PurchaseReceiptMapper mapper;

    public Integer insert(PurchaseReceiptModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(PurchaseReceiptModel model) {
        return mapper.update(model);
    }

    public List<PurchaseReceiptModel> select(PurchaseReceiptQueryModel model) {
        return mapper.select(model);
    }
}
