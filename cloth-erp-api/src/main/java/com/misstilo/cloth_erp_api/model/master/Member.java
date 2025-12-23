package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 會員 (Members)
 * [cite: 115]
 */
@Data
public class Member implements Serializable {
  private Integer memberId; // Identity

  /**
   * 會員編號 (Unique)
   * [cite: 117]
   */
  private String memberCode;

  private String name;

  /**
   * 手機號碼 (Unique)
   * [cite: 120]
   */
  private String phone;

  private String address;
  private String note;

  private Boolean isActive;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
