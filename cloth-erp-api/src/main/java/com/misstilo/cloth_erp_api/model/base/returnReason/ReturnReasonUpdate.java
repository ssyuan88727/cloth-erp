package com.misstilo.cloth_erp_api.model.base.returnReason;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnReasonUpdate {
    @NotNull(message = "Update: id is required.")
    private Integer id;
    @NotBlank(message = "原因不可為空")
    @Size(max = 10, message = "原因不可超過10字")
    private String reason;
}
