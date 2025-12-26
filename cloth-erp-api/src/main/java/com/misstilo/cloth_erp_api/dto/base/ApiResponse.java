package com.misstilo.cloth_erp_api.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "API 回傳格式")
public class ApiResponse {
    @Schema(description = "是否成功", example = "true")
    private Boolean success;
    @Schema(description = "訊息", example = "成功")
    private String msg;
    @Schema(description = "回傳資料")
    private Object data;
}
