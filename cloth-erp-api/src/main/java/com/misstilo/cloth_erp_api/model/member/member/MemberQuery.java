package com.misstilo.cloth_erp_api.model.member.member;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberQuery {
    @Size(max = 20, message = "會員編號不可超過20個字")
    private String code;
    @Size(max = 50, message = "會員姓名不可超過50個字")
    private String name;
    @Size(max = 20, message = "電話不可超過20個字")
    private String phone;
    @Size(max = 100, message = "電子郵件不可超過100個字")
    private String email;
    @Size(max = 255, message = "地址不可超過255個字")
    private String address;
    private String joinDateS;
    private String joinDateE;
    private Boolean isActive;
    private String createAtS;
    private String createAtE;
    private String updateAtS;
    private String updateAtE;
}
