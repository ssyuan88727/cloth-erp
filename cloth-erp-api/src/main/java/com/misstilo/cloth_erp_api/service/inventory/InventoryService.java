package com.misstilo.cloth_erp_api.service.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryResponse;
import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryUpdate;
import com.misstilo.cloth_erp_api.mapper.inventory.inventory.InventoryMapper;
import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryCreate;
import com.misstilo.cloth_erp_api.model.inventory.inventory.InventoryQuery;

import lombok.Builder;

@Service
@Builder
public class InventoryService {
  @Autowired
  private final InventoryMapper mapper;

  public Integer insert(InventoryCreate model) {
    return mapper.insert(model);
  }

  public Integer delete(Integer id) {
    return mapper.delete(id);
  }

  public Integer update(InventoryUpdate model) {
    return mapper.update(model);
  }

  public List<InventoryResponse> select(InventoryQuery model) {
    return mapper.select(model);
  }

}
