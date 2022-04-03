package com.comarch.appcomarch.repositories;

import com.comarch.appcomarch.model.Product;
import com.comarch.appcomarch.model.ProductWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductWarehouseRepo extends JpaRepository<ProductWarehouse, Long> {

    List<ProductWarehouse> getProductWarehouseByIsAvailable(Boolean flag);

    Optional<ProductWarehouse> getProductWarehouseById(Long id);

    List<ProductWarehouse> getProductWarehouseByProductIdAndIsAvailable(Long productId, Boolean flag);

}
