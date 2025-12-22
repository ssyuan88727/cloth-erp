package com.misstilo.cloth_erp_api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StockTakingStatus implements BaseEnum<Integer> {
  DRAFT(0, "盤點中"), //
  COUNTED(1, "數量輸入完畢"), //
  APPROVED(2, "已簽核"), // 鎖定
  VOID(3, "作廢"); //

  private final Integer code;
  private final String description;
}
