package com.misstilo.cloth_erp_api.model.base.returnReason;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnReasonResponse {
    private Integer id;
    private String reason;
}
