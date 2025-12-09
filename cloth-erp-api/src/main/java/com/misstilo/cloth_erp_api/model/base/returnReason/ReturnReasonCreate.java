package com.misstilo.cloth_erp_api.model.base.returnReason;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReturnReasonCreate {
    @NotBlank(message = "原因不可為空")
    @Size(max = 10, message = "原因不可超過10字")
    private String reason;
}
