package com.comarch.appcomarch.controllers;

import com.comarch.appcomarch.model.ProductWarehouse;
import com.comarch.appcomarch.services.impl.ProductWarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productWarehouse")
public class ProductWarehouseController {
    private ProductWarehouseServiceImpl productWarehouseService;
    @Autowired
    public ProductWarehouseController(ProductWarehouseServiceImpl productWarehouseService){
        this.productWarehouseService = productWarehouseService;
    }

    @GetMapping("/getAvailable")
    public List<ProductWarehouse> getAvailableProducts() {
        return productWarehouseService.getAvailableProducts(true);
    }

    @GetMapping("/getByProductIdAndIsAvailable")
    public List<ProductWarehouse> getProductWarehouseByProductIdAndIsAvailable(@RequestParam Long productId) {
        return productWarehouseService.getProductWarehouseByProductIdAndIsAvailable(productId, true);
    }

    @GetMapping("getById")
    public ProductWarehouse getProductWarehouseById(@RequestParam Long productWarehouseId) {
        return productWarehouseService.getProductWarehouseById(productWarehouseId);
    }

    @PutMapping("/update")
    public ProductWarehouse updateProductWarehouse(@RequestBody ProductWarehouse productWarehouse) {
        return productWarehouseService.updateProductWarehouse(productWarehouse);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductWarehouse> addProductWarehouse(@RequestBody ProductWarehouse productWarehouse) {
        return new ResponseEntity<>(productWarehouseService.addProductWarehouse(productWarehouse), HttpStatus.CREATED);
    }
}
