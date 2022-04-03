package com.comarch.appcomarch.controllers;

import com.comarch.appcomarch.model.Product;
import com.comarch.appcomarch.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductServiceImpl productService;
    @Autowired
    ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }

    @PatchMapping("/setPrice/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestParam BigDecimal price) {
        return productService.updatePrice(id, price);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/getByName")
    public List<Product> getProductByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/getById")
    public Product getProductById(@RequestParam Long productId) {
        return productService.getProductById(productId);
    }
}
