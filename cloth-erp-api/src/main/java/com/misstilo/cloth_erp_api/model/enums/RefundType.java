package com.misstilo.cloth_erp_api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 退款方式
 * [cite: 277]
 */
@Getter
@AllArgsConstructor
public enum RefundType implements BaseEnum<Integer> {
  CASH(1, "現金/刷退"), // [cite: 279]
  CREDIT(2, "購物金/保留款"); // [cite: 280]

  private final Integer code;
  private final String description;
}
