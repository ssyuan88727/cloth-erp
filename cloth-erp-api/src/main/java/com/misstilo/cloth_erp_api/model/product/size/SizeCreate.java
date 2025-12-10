package com.misstilo.cloth_erp_api.model.product.size;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SizeCreate {
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "代號僅可為英文字母與數字")
    @NotBlank(message = "代號不可為空")
    @Size(max = 10, message = "代號不可超過10個字")
    private String code;
    @NotBlank(message = "名稱不可為空")
    @Size(max = 20, message = "名稱不可超過20個字")
    private String name;
}
