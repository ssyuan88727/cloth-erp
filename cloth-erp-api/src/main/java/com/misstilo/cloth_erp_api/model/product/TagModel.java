package com.misstilo.cloth_erp_api.model.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TagModel {
    private Integer id;
    @NotBlank(message = "名稱不可為空")
    @Size(max = 10, message = "名稱最多10個字")
    private String name;
}
