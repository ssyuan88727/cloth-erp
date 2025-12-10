package com.misstilo.cloth_erp_api.model.product.color;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColorResponse {
  private Integer id;
  private String code;
  private String name;
}
