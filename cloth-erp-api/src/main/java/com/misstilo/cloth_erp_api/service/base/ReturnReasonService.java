package com.misstilo.cloth_erp_api.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.base.ReturnReasonMapper;
import com.misstilo.cloth_erp_api.model.base.ReturnReasonModel;
import com.misstilo.cloth_erp_api.model.base.ReturnReasonQueryModel;

import lombok.Builder;

@Service
@Builder
public class ReturnReasonService {
    @Autowired
    private final ReturnReasonMapper mapper;

    public Integer insert(ReturnReasonModel model) {
        return mapper.insert(model);
    }

    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    public Integer update(ReturnReasonModel model) {
        return mapper.update(model);
    }

    public List<ReturnReasonModel> select(ReturnReasonQueryModel model) {
        return mapper.select(model);
    }
}
