package com.misstilo.cloth_erp_api.model.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseHeaderModel {
    @NotNull(message = "Status is required.")
    private Boolean status;
    private String title;
    private String message;
}
