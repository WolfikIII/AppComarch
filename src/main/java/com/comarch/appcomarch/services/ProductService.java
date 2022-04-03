package com.comarch.appcomarch.services;

import com.comarch.appcomarch.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product updatePrice(Long ProductId, BigDecimal price);

    Product addProduct(Product product);

    List<Product> getProductsByName(String name);

    Product getProductById(Long productId);
}
