package com.misstilo.cloth_erp_api.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.sales.paymentMethod.PaymentMethodMapper;
import com.misstilo.cloth_erp_api.model.sales.paymentMethod.PaymentMethodCreate;
import com.misstilo.cloth_erp_api.model.sales.paymentMethod.PaymentMethodQuery;
import com.misstilo.cloth_erp_api.model.sales.paymentMethod.PaymentMethodResponse;
import com.misstilo.cloth_erp_api.model.sales.paymentMethod.PaymentMethodUpdate;

import lombok.Builder;

@Service
@Builder
public class PaymentMethodService {
    @Autowired
    private final PaymentMethodMapper mapper;

    @Transactional
    public Integer insert(PaymentMethodCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(PaymentMethodUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<PaymentMethodResponse> select(PaymentMethodQuery model) {
        return mapper.select(model);
    }
}
