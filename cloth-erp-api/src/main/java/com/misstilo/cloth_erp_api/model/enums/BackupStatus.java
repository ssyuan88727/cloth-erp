package com.misstilo.cloth_erp_api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BackupStatus implements BaseEnum<Integer> {
  FAILED(1, "備份失敗"),
  SUCCESS(2, "備份成功"),
  SKIPPED(3, "略過備份"); // 修正規格書重複 Key 的問題

  private final Integer code;
  private final String description;
}
