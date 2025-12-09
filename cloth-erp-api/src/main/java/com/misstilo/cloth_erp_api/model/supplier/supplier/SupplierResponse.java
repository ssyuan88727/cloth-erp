package com.misstilo.cloth_erp_api.model.supplier.supplier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponse {
    private Integer id;
    private String code;
    private String name;
    private String contactName;
    private String contactPhone;
    private String address;
    private Boolean isActive;
    private String createAt;
    private String updateAt;
}
