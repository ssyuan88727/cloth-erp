package com.misstilo.cloth_erp_api.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misstilo.cloth_erp_api.mapper.product.productSku.ProductSkuMapper;
import com.misstilo.cloth_erp_api.model.product.color.ColorQuery;
import com.misstilo.cloth_erp_api.model.product.product.ProductQuery;
import com.misstilo.cloth_erp_api.model.product.prosuctSku.ProductSkuResponse;
import com.misstilo.cloth_erp_api.model.product.size.SizeQueryModel;
import com.misstilo.cloth_erp_api.model.supplier.supplier.SupplierQuery;
import com.misstilo.cloth_erp_api.service.supplier.SupplierService;

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

  public Integer insert(ProductSkuResponse model) {
    // ProductQueryModel productQuery = ProductQueryModel.builder().id(model.getProductId()).build();
    // String productCode = productService.select(productQuery).get(0).getCode();

    // SupplierQueryModel supplierQuery = SupplierQueryModel.builder().id(model.getSupplierId()).build();
    // String supplierCode = supplierService.select(supplierQuery).get(0).getCode();

    // ColorQueryModel colorQuery = ColorQueryModel.builder().id(model.getColorId()).build();
    // String colorCode = colorService.select(colorQuery).get(0).getCode();

    // SizeQueryModel sizeQuery = SizeQueryModel.builder().id(model.getSizeId()).build();
    // String sizeCode = sizeService.select(sizeQuery).get(0).getCode();

    // model.setSkuCode(productCode + "-" + supplierCode + "-" + colorCode + "-" + sizeCode);
    return mapper.insert(model);
  }

  public Integer delete(Integer id) {
    return mapper.delete(id);
  }

  public Integer update(ProductSkuResponse model) {
    return mapper.update(model);
  }

  public List<ProductSkuResponse> select(Integer id) {
    return mapper.select(id);
  }
}
