package com.misstilo.cloth_erp_api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StockDocType implements BaseEnum<Integer> {
  PO_IN(1, "採購進貨"),
  PO_RET(2, "採購退回"),
  SO_OUT(3, "銷貨出庫"),
  SO_RET(4, "銷貨退回"),
  ADJ(5, "庫存調整");

  private final Integer code;
  private final String description;
}
