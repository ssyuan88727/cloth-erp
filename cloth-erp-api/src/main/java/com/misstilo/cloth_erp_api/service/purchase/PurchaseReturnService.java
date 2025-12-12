package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.purchase.purchaseReturn.PurchaseReturnMapper;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturn.PurchaseReturnCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturn.PurchaseReturnQuery;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturn.PurchaseReturnResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturn.PurchaseReturnUpdate;

import lombok.Builder;

@Service
@Builder
public class PurchaseReturnService {
    @Autowired
    private final PurchaseReturnMapper mapper;

    @Transactional
    public Integer insert(PurchaseReturnCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(PurchaseReturnUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<PurchaseReturnResponse> select(PurchaseReturnQuery model) {
        return mapper.select(model);
    }
}
