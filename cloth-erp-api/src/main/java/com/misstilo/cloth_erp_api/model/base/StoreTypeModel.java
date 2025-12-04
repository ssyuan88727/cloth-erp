package com.misstilo.cloth_erp_api.model.base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StoreTypeModel {
    private Integer id;
    @NotBlank(message = "名稱不可為空")
    @Size(max = 20, message = "名稱不可超過20字")
    private String name;
}
