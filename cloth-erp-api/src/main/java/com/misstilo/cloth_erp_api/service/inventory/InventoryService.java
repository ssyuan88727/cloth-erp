package com.misstilo.cloth_erp_api.service.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  @Transactional
  public Integer insert(InventoryCreate model) {
    return mapper.insert(model);
  }

  @Transactional
  public Integer delete(Integer id) {
    return mapper.delete(id);
  }

  @Transactional
  public Integer update(InventoryUpdate model) {
    return mapper.update(model);
  }

  @Transactional
  public List<InventoryResponse> select(InventoryQuery model) {
    return mapper.select(model);
  }

}
