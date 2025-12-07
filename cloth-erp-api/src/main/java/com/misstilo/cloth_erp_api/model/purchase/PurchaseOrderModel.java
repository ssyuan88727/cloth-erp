package com.misstilo.cloth_erp_api.model.purchase;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderModel {
  private Integer id;
  private Boolean confirmed;
  private Boolean signed;
  private String code;
  private String date;
  @NotNull(message = "供應商不可為空")
  private Integer supplierId;
  private String supplierName;
  private Integer totQty;
  private Integer totAmt;
  private String remark;
  private String createAt;
  private String updateAt;
}
