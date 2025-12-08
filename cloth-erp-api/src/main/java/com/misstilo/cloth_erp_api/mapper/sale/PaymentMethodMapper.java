package com.misstilo.cloth_erp_api.mapper.sale;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.sale.PaymentMethodModel;
import com.misstilo.cloth_erp_api.model.sale.PaymentMethodQueryModel;

@Mapper
public interface PaymentMethodMapper {
    Integer insert(PaymentMethodModel model);

    Integer delete(Integer id);

    Integer update(PaymentMethodModel model);

    List<PaymentMethodModel> select(PaymentMethodQueryModel model);
}
