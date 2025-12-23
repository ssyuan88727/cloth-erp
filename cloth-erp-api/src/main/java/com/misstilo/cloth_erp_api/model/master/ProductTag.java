package com.misstilo.cloth_erp_api.model.master;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 商品標籤關聯 (ProductTags)
 * [cite: 144]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTag implements Serializable {
  /**
   * 關聯商品 (PK, FK)
   * [cite: 145]
   */
  private String productId;

  /**
   * 關聯標籤 (PK, FK)
   * [cite: 146]
   */
  private Integer tagId;

  // 此表為純關聯，通常不強制要求 createdAt/updatedAt，但若需追蹤貼標籤時間可加入
  private static final long serialVersionUID = 1L;
}
