package com.misstilo.cloth_erp_api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 進貨單狀態
 * [cite: 217-219]
 */
@Getter
@AllArgsConstructor
public enum ReceivingStatus implements BaseEnum<Integer> {
  DRAFT(0, "點收中"), // [cite: 218] 不影響庫存
  CONFIRMED(1, "確認入庫"); // 觸發成本計算與庫存增加

  private final Integer code;
  private final String description;
}
