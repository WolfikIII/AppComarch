package com.comarch.appcomarch.services.impl;

import com.comarch.appcomarch.model.ProductWarehouse;
import com.comarch.appcomarch.repositories.ProductWarehouseRepo;
import com.comarch.appcomarch.services.ProductWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductWarehouseServiceImpl implements ProductWarehouseService {

   private ProductWarehouseRepo productWarehouseRepo;

   @Autowired
   public ProductWarehouseServiceImpl(ProductWarehouseRepo productWarehouseRepo) {
      this.productWarehouseRepo = productWarehouseRepo;
   }

   @Override
   public List<ProductWarehouse> getAvailableProducts(Boolean flag) {
      List<ProductWarehouse> productWarehouseList = productWarehouseRepo.getProductWarehouseByIsAvailable(true);
      if(productWarehouseList == null || productWarehouseList.size() == 0) {
         throw new RuntimeException("No available products");
      }
      return productWarehouseRepo.getProductWarehouseByIsAvailable(true);
   }

   @Override
   public List<ProductWarehouse> getProductWarehouseByProductIdAndIsAvailable(Long productId, Boolean isAvailable) {
      List<ProductWarehouse> productWarehouseList = productWarehouseRepo.getProductWarehouseByProductIdAndIsAvailable(productId, isAvailable);
      if(productWarehouseList == null || productWarehouseList.size() == 0) {
         throw new RuntimeException("No available products");
      }
      return productWarehouseRepo.getProductWarehouseByProductIdAndIsAvailable(productId, isAvailable);
   }

   @Override
   public ProductWarehouse getProductWarehouseById(Long productWarehouseId) {
      return productWarehouseRepo.getProductWarehouseById(productWarehouseId).orElseThrow(()-> new RuntimeException("Product not found"));
   }

   @Override
   public ProductWarehouse updateProductWarehouse(ProductWarehouse productWarehouse) {
      return productWarehouseRepo.save(productWarehouse);
   }

   @Override
   public ProductWarehouse addProductWarehouse(ProductWarehouse productWarehouse) {
      return productWarehouseRepo.save(productWarehouse);
   }


}
