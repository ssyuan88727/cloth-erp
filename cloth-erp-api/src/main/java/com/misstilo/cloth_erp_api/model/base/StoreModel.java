package com.misstilo.cloth_erp_api.model.base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StoreModel {
    private Integer id;
    @NotBlank(message = "代號不可為空")
    @Size(max = 10, message = "代號不可超過10字")
    private String code;
    @NotBlank(message = "名稱不可為空")
    @Size(max = 20, message = "名稱不可超過100字")
    private String name;
    @NotNull(message = "店點類型不可為空")
    private Integer storeTypeId;
    private String storeTypeName;
    private Boolean isActive;
    private String createAt;
    private String updateAt;
}
