package com.misstilo.cloth_erp_api.model.product;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TagQueryModel {
    @Size(max = 10, message = "名稱最多10個字")
    private String name;
}
