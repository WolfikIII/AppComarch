package com.comarch.appcomarch.services.impl;

import com.comarch.appcomarch.model.Product;
import com.comarch.appcomarch.repositories.ProductRepo;
import com.comarch.appcomarch.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

   private ProductRepo productRepo;

   @Autowired
   public ProductServiceImpl(ProductRepo productRepo){
       this.productRepo = productRepo;
   }

   @Override
   public Product updatePrice(Long id, BigDecimal price) {
        Product product = productRepo.getById(id);
        product.setPrice(price);
        return productRepo.save(product);
    }

    @Override
    public Product addProduct(Product product) {
       return productRepo.save(product);
    }

    @Override
    public List<Product> getProductsByName(String name) {
       List<Product> productList = productRepo.getProductByNameLike(name);
       if(productList == null || productList.size() == 0)
       {
           throw new RuntimeException("Products not found");
       }
       return productRepo.getProductByNameLike(name);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepo.getProductById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
