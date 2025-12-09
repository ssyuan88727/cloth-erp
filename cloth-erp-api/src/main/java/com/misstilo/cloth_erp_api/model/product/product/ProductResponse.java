package com.misstilo.cloth_erp_api.model.product.product;

import java.math.BigDecimal;
import java.util.List;

import com.misstilo.cloth_erp_api.model.product.tag.TagResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
  private Integer id;
  private String code;
  private String name;
  private List<TagResponse> tag;
  private BigDecimal unitPrc;
  private Boolean isActive;
  private String remark;
  private String createAt;
  private String updateAt;
}
