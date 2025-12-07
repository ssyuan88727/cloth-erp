package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.product.InventoryMapper;
import com.misstilo.cloth_erp_api.model.product.InventoryModel;
import com.misstilo.cloth_erp_api.model.product.InventoryQueryModel;

import lombok.Builder;

@Service
@Builder
public class InventoryService {
  @Autowired
  private final InventoryMapper mapper;

  public Integer insert(InventoryModel model) {
    return mapper.insert(model);
  }

  public Integer delete(Integer id) {
    return mapper.delete(id);
  }

  public Integer update(InventoryModel model) {
    return mapper.update(model);
  }

  public List<InventoryModel> select(InventoryQueryModel model) {
    return mapper.select(model);
  }

}
