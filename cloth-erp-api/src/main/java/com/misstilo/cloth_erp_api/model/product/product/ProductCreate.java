package com.misstilo.cloth_erp_api.model.product.product;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class ProductCreate {
    private Integer id;
    @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "代號僅可為應為字母與數字")
    @NotBlank(message = "代號不可為空")
    @Size(max = 20, message = "代號不可超過20字")
    private String code;
    @NotBlank(message = "名稱不可為空")
    @Size(max = 20, message = "名稱不可超過20字")
    private String name;
    private List<Integer> tag;
    @NotNull(message = "價格不可為空")
    private BigDecimal unitPrc;
    private Boolean isActive;
    @Size(max = 255, message = "備註不可超過255個字")
    private String remark;
}
