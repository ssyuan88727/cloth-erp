package com.misstilo.cloth_erp_api.mapper.purchase.purchaseReturn;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.purchase.purchaseReturn.PurchaseReturnCreate;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturn.PurchaseReturnQuery;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturn.PurchaseReturnResponse;
import com.misstilo.cloth_erp_api.model.purchase.purchaseReturn.PurchaseReturnUpdate;

@Mapper
public interface PurchaseReturnMapper {
    Integer insert(PurchaseReturnCreate model);

    Integer delete(Integer id);

    Integer update(PurchaseReturnUpdate model);

    List<PurchaseReturnResponse> select(PurchaseReturnQuery model);
}
