package com.misstilo.cloth_erp_api.model.member.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    @NotBlank(message = "編號不可為空")
    @Size(max = 20, message = "編號不可超過20個字")
    private String code;
    @NotBlank(message = "姓名不可為空")
    @Size(max = 50, message = "姓名不可超過50個字")
    private String name;
    @Size(max = 100, message = "電子郵件不可超過100個字")
    private String email;
    @Size(max = 255, message = "地址不可超過255個字")
    private String address;
    private String joinDate;
    private Boolean isActive;
}
