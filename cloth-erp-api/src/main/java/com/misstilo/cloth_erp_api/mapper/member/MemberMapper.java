package com.misstilo.cloth_erp_api.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.misstilo.cloth_erp_api.model.member.MemberModel;
import com.misstilo.cloth_erp_api.model.member.MemberQueryModel;

@Mapper
public interface MemberMapper {
    Integer insert(MemberModel model);

    Integer delete(Integer id);

    Integer update(MemberModel model);

    List<MemberModel> select(MemberQueryModel model);
}
