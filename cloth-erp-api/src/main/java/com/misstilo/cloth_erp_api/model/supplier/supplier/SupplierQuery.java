package com.misstilo.cloth_erp_api.model.supplier.supplier;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierQuery {
    @Size(max = 10, message = "代號不可超過10字")
    private String code;
    @Size(max = 20, message = "名稱不可超過20字")
    private String name;
    @Size(max = 20, message = "聯絡人名稱不可超過20字")
    private String contactName;
    @Size(max = 20, message = "聯絡人電話不可超過20字")
    private String contactPhone;
    @Size(max = 255, message = "地址不可超過255個字")
    private String address;
    private Boolean isActive;
    private String createAtS;
    private String createAtE;
    private String updateAtS;
    private String updateAtE;
}
