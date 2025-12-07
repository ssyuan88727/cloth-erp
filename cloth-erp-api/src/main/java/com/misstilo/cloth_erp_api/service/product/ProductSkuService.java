package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.product.ProductSkuMapper;
import com.misstilo.cloth_erp_api.model.base.SupplierQueryModel;
import com.misstilo.cloth_erp_api.model.product.ColorQueryModel;
import com.misstilo.cloth_erp_api.model.product.ProductQueryModel;
import com.misstilo.cloth_erp_api.model.product.ProductSkuModel;
import com.misstilo.cloth_erp_api.model.product.SizeQueryModel;
import com.misstilo.cloth_erp_api.service.base.SupplierService;

import lombok.Builder;

@Service
@Builder
public class ProductSkuService {
  @Autowired
  private final ProductSkuMapper mapper;
  @Autowired
  private final ProductService productService;
  @Autowired
  private final SupplierService supplierService;
  @Autowired
  private final ColorService colorService;
  @Autowired
  private final SizeService sizeService;

  public Integer insert(ProductSkuModel model) {
    ProductQueryModel productQuery = ProductQueryModel.builder().id(model.getProductId()).build();
    String productCode = productService.select(productQuery).get(0).getCode();

    SupplierQueryModel supplierQuery = SupplierQueryModel.builder().id(model.getSupplierId()).build();
    String supplierCode = supplierService.select(supplierQuery).get(0).getCode();

    ColorQueryModel colorQuery = ColorQueryModel.builder().id(model.getColorId()).build();
    String colorCode = colorService.select(colorQuery).get(0).getCode();

    SizeQueryModel sizeQuery = SizeQueryModel.builder().id(model.getSizeId()).build();
    String sizeCode = sizeService.select(sizeQuery).get(0).getCode();

    model.setSkuCode(productCode + "-" + supplierCode + "-" + colorCode + "-" + sizeCode);
    return mapper.insert(model);
  }

  public Integer delete(Integer id) {
    return mapper.delete(id);
  }

  public Integer update(ProductSkuModel model) {
    return mapper.update(model);
  }

  public List<ProductSkuModel> select(Integer id) {
    return mapper.select(id);
  }
}
