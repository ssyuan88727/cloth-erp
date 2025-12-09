package com.misstilo.cloth_erp_api.model.base.returnReason;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnReasonQuery {
    @Size(max = 10, message = "原因不可超過10個字")
    private String reason;
}
