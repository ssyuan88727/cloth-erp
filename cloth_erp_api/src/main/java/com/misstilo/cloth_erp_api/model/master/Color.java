package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Color implements Serializable { // [cite: 125]
  private Integer colorId; // PK
  private String colorName; // [cite: 127] e.g., '酒紅'
  private String colorCode; // [cite: 128] e.g., 'WINERED' (Unique)
  private Integer sortOrder; // [cite: 130]
  private Boolean isActive;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
