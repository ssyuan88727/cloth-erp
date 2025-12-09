package com.misstilo.cloth_erp_api.model.store.storeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreTypeResponse {
    private Integer id;
    private String name;
}
