package com.misstilo.cloth_erp_api.model.base;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnReasonModel {
    private Integer id;
    @NotBlank(message = "原因不可為空")
    @Size(max = 10, message = "原因不可超過10個字")
    private String reason;
}
