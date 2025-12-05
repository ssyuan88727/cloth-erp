package com.misstilo.cloth_erp_api.model.base;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StoreQueryModel {
    @Size(max = 10, message = "代號不可超過10字")
    private String code;
    @Size(max = 20, message = "名稱不可超過20字")
    private String name;
    private Integer storeTypeId;
    private Boolean isActive;
    private String createAtS;
    private String createAtE;
    private String updateAtS;
    private String updateAtE;
}
