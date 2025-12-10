package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misstilo.cloth_erp_api.mapper.product.color.ColorMapper;
import com.misstilo.cloth_erp_api.mapper.product.product.ProductMapper;
import com.misstilo.cloth_erp_api.mapper.product.productSku.ProductSkuMapper;
import com.misstilo.cloth_erp_api.mapper.product.size.SizeMapper;
import com.misstilo.cloth_erp_api.mapper.supplier.supplier.SupplierMapper;
import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuCreate;
import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuResponse;
import com.misstilo.cloth_erp_api.model.product.productSku.ProductSkuUpdate;

import lombok.Builder;

@Service
@Builder
public class ProductSkuService {
  @Autowired
  private final ProductSkuMapper mapper;
  @Autowired
  private final ProductMapper productMapper;
  @Autowired
  private final SupplierMapper supplierMapper;
  @Autowired
  private final ColorMapper colorMapper;
  @Autowired
  private final SizeMapper sizeMapper;

  @Transactional
  public Integer insert(ProductSkuCreate model) {
    String productCode = productMapper.getCodeById(model.getProductId());
    String supplierCode = supplierMapper.getCodeById(model.getSupplierId());
    String colorCode = colorMapper.getCodeById(model.getColorId());
    String sizeCode = sizeMapper.getCodeById(model.getSizeId());
    if (StringUtils.isBlank(productCode) || StringUtils.isBlank(supplierCode) || StringUtils.isBlank(colorCode)
        || StringUtils.isBlank(sizeCode)) {
      throw new IllegalArgumentException("SkuCode 組成要件缺失");
    }
    model.setSkuCode(String.join("-", productCode, supplierCode, colorCode, sizeCode));
    return mapper.insert(model);
  }

  @Transactional
  public Integer delete(Integer id) {
    return mapper.delete(id);
  }

  @Transactional
  public Integer update(ProductSkuUpdate model) {
    return mapper.update(model);
  }

  @Transactional
  public List<ProductSkuResponse> select(Integer productId) {
    return mapper.select(productId);
  }
}
