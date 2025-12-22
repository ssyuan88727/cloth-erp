package com.misstilo.cloth_erp_api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReasonType implements BaseEnum<String> {
  SO("SO", "銷貨退回"),
  PO("PO", "採購退出"),
  ALL("ALL", "通用");

  private final String code;
  private final String description;
}
