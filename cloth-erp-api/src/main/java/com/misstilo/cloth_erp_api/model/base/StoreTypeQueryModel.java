package com.misstilo.cloth_erp_api.model.base;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StoreTypeQueryModel {
    @Size(max = 20, message = "名稱不可超過20字")
    private String name;
}
