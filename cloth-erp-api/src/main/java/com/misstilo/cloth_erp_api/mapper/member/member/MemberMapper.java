package com.misstilo.cloth_erp_api.mapper.member.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.member.member.MemberCreate;
import com.misstilo.cloth_erp_api.model.member.member.MemberQuery;
import com.misstilo.cloth_erp_api.model.member.member.MemberResponse;
import com.misstilo.cloth_erp_api.model.member.member.MemberUpdate;

@Mapper
public interface MemberMapper {
    Integer insert(MemberCreate model);

    Integer delete(Integer id);

    Integer update(MemberUpdate model);

    List<MemberResponse> select(MemberQuery model);
}
