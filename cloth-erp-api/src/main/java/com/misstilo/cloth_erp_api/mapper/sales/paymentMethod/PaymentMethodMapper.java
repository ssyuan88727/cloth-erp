package com.misstilo.cloth_erp_api.mapper.sales.paymentMethod;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.sales.paymentMethod.PaymentMethodCreate;
import com.misstilo.cloth_erp_api.model.sales.paymentMethod.PaymentMethodQuery;
import com.misstilo.cloth_erp_api.model.sales.paymentMethod.PaymentMethodResponse;
import com.misstilo.cloth_erp_api.model.sales.paymentMethod.PaymentMethodUpdate;

@Mapper
public interface PaymentMethodMapper {
    Integer insert(PaymentMethodCreate model);

    Integer delete(Integer id);

    Integer update(PaymentMethodUpdate model);

    List<PaymentMethodResponse> select(PaymentMethodQuery model);
}
