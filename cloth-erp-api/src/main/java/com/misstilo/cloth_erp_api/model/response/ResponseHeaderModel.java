package com.misstilo.cloth_erp_api.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseHeaderModel {
    private Boolean status;
    private String title;
    private String message;
}
