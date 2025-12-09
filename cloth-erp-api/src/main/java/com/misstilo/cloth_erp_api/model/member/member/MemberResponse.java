package com.misstilo.cloth_erp_api.model.member.member;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private Integer id;
    private String code;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String joinDate;
    private Integer totQty;
    private BigDecimal totAmt;
    private Integer totCnt;
    private Boolean isActive;
    private String createAt;
    private String updateAt;
}
