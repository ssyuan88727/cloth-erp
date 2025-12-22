package com.misstilo.cloth_erp_api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PurchaseOrderStatus implements BaseEnum<Integer> {
  DRAFT(0, "未確認"), //
  CONFIRMED(1, "已確認"), // 待進貨
  CLOSED(2, "已結案"), //
  FORCE_CLOSED(3, "強制結案"); //

  private final Integer code;
  private final String description;
}
