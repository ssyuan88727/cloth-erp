package com.misstilo.cloth_erp_api.model.supplier.supplier;

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
public class SupplierUpdate {
    @NotNull(message = "Update: Id is required.")
    private Integer id;
    @NotBlank(message = "名稱不可為空")
    @Size(max = 20, message = "名稱不可超過20字")
    private String name;
    @Size(max = 20, message = "聯絡人名稱不可超過20字")
    private String contactName;
    @Size(max = 20, message = "聯絡人電話不可超過20字")
    private String contactPhone;
    @Size(max = 255, message = "地址不可超過255個字")
    private String address;
    private Boolean isActive;
}
