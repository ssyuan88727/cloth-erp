package com.misstilo.cloth_erp_api.model.product.color;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColorQuery {
  @Size(max = 10, message = "代號不可超過10字")
  private String code;
  @Size(max = 20, message = "名稱不可超過20字")
  private String name;
}
