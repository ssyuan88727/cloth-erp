package com.misstilo.cloth_erp_api.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.base.returnReason.ReturnReasonMapper;
import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonResponse;
import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonUpdate;
import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonCreate;
import com.misstilo.cloth_erp_api.model.base.returnReason.ReturnReasonQuery;

import lombok.Builder;

@Service
@Builder
public class ReturnReasonService {
    @Autowired
    private final ReturnReasonMapper mapper;

    @Transactional
    public Integer insert(ReturnReasonCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(ReturnReasonUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<ReturnReasonResponse> select(ReturnReasonQuery model) {
        return mapper.select(model);
    }
}
