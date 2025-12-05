package com.misstilo.cloth_erp_api.model.base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SupplierModel {
    private Integer id;
    @NotBlank(message = "代號不可為空")
    @Size(max = 10, message = "代號不可超過10字")
    private String code;
    @NotBlank(message = "名稱不可為空")
    @Size(max = 20, message = "名稱不可超過20字")
    private String name;
    @Size(max = 20, message = "聯絡人名稱不可超過50字")
    private String contactName;
    @Size(max = 20, message = "聯絡人電話不可超過20字")
    private String contactPhone;
    @Size(max = 255, message = "地址不可超過255個字")
    private String address;
    private Boolean isActive;
    private String createAt;
    private String updateAt;
}
