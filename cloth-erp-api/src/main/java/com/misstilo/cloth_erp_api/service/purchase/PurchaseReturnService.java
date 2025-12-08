package com.misstilo.cloth_erp_api.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.purchase.PurchaseReturnMapper;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseReturnModel;
import com.misstilo.cloth_erp_api.model.purchase.PurchaseReturnQueryModel;

import lombok.Builder;

@Service
@Builder
public class PurchaseReturnService {
    @Autowired
    private final PurchaseReturnMapper mapper;

    public Integer insert(PurchaseReturnModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(PurchaseReturnModel model) {
        return mapper.update(model);
    }

    public List<PurchaseReturnModel> select(PurchaseReturnQueryModel model) {
        return mapper.select(model);
    }
}
