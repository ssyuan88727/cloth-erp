package com.misstilo.cloth_erp_api.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.member.member.MemberMapper;
import com.misstilo.cloth_erp_api.model.member.member.MemberCreate;
import com.misstilo.cloth_erp_api.model.member.member.MemberQuery;
import com.misstilo.cloth_erp_api.model.member.member.MemberResponse;
import com.misstilo.cloth_erp_api.model.member.member.MemberUpdate;

import lombok.Builder;

@Service
@Builder
public class MemberService {
    @Autowired
    private final MemberMapper mapper;

    @Transactional
    public Integer insert(MemberCreate model) {
        return mapper.insert(model);
    }

    @Transactional
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }

    @Transactional
    public Integer update(MemberUpdate model) {
        return mapper.update(model);
    }

    @Transactional
    public List<MemberResponse> select(MemberQuery model) {
        return mapper.select(model);
    }
}
