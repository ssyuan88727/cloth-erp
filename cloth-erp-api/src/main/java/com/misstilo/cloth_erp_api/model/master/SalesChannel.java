package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 銷售通路 (SalesChannels)
 * [cite: 103]
 */
@Data
public class SalesChannel implements Serializable {
  private Integer channelId;
  private String channelName;

  /**
   * 平台手續費率
   * DECIMAL(5, 4), e.g., 0.0550
   */
  private BigDecimal feeRate;

  /**
   * 退貨運費負擔
   * [cite: 108] 賣家需自行吸收的標準運費成本
   */
  private BigDecimal returnShippingFee;

  private Boolean isActive;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
