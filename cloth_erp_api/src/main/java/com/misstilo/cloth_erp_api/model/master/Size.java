package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Size implements Serializable { // [cite: 132]
  private Integer sizeId; // PK
  private String sizeName; // [cite: 134] e.g., '特大'
  private String sizeCode; // [cite: 135] e.g., 'XL'
  private Integer sortOrder; // [cite: 136] Logic: XS, S, M, L...
  private Boolean isActive;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
