package com.comarch.appcomarch.services;

import com.comarch.appcomarch.model.ProductWarehouse;

import java.util.List;

public interface ProductWarehouseService {

    List<ProductWarehouse> getAvailableProducts(Boolean flag);

    List<ProductWarehouse> getProductWarehouseByProductIdAndIsAvailable(Long productId, Boolean isAvailable);

    ProductWarehouse getProductWarehouseById(Long productWarehouseId);

    ProductWarehouse updateProductWarehouse(ProductWarehouse productWarehouse);

    ProductWarehouse addProductWarehouse(ProductWarehouse productWarehouse);
}
