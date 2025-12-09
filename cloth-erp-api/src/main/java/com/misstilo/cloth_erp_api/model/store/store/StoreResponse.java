package com.misstilo.cloth_erp_api.model.store.store;

import com.misstilo.cloth_erp_api.model.store.storeType.StoreTypeResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponse {
    private Integer id;
    private String code;
    private String name;
    private StoreTypeResponse storeType;
    private Boolean isActive;
    private String createAt;
    private String updateAt;
}
