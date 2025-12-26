package com.misstilo.cloth_erp_api.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PageReq {
    @Schema(description = "頁碼(從1開始)", example = "1")
    private Integer pageNum = 1;
    @Schema(description = "每頁筆數", example = "10")
    private Integer pageSize = 10;

    public Integer getPageSize() {
        if (this.pageNum == null || this.pageSize <= 0)
            return 10;
        if (this.pageSize > 1000)
            return 1000;
        return this.pageSize;
    }
}
