package com.comarch.appcomarch.services;

import com.comarch.appcomarch.model.Product;

import java.math.BigDecimal;


public interface ProductService {

    Product updatePrice(Long ProductId, BigDecimal price);

    Product addProduct(Product product);

    Product getProductByName(String name);

    Product getProductById(Long productId);
}
