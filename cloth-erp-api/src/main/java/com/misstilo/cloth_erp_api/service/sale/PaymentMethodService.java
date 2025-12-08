package com.misstilo.cloth_erp_api.service.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.sale.PaymentMethodMapper;
import com.misstilo.cloth_erp_api.model.sale.PaymentMethodModel;
import com.misstilo.cloth_erp_api.model.sale.PaymentMethodQueryModel;

import lombok.Builder;

@Service
@Builder
public class PaymentMethodService {
    @Autowired
    private final PaymentMethodMapper mapper;

    public Integer insert(PaymentMethodModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(PaymentMethodModel model) {
        return mapper.update(model);
    }

    public List<PaymentMethodModel> select(PaymentMethodQueryModel model) {
        return mapper.select(model);
    }
}
