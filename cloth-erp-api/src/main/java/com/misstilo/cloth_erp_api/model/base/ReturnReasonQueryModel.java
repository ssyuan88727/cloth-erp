package com.misstilo.cloth_erp_api.model.base;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReturnReasonQueryModel {
    @Size(max = 10, message = "原因不可超過10個字")
    private String reason;
}
