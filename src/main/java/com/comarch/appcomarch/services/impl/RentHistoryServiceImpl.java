package com.comarch.appcomarch.services.impl;


import com.comarch.appcomarch.model.Product;
import com.comarch.appcomarch.model.ProductWarehouse;
import com.comarch.appcomarch.model.RentHistory;
import com.comarch.appcomarch.repositories.RentHistoryRepo;
import com.comarch.appcomarch.services.ClientService;
import com.comarch.appcomarch.services.RentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RentHistoryServiceImpl implements RentHistoryService {

    private final RentHistoryRepo rentHistoryRepo;
    private final ProductWarehouseServiceImpl productWarehouseService;
    private final ProductServiceImpl productService;
    private final ClientService clientService;

    @Autowired
    public RentHistoryServiceImpl(
            RentHistoryRepo rentHistoryRepo,
            ProductWarehouseServiceImpl productWarehouseService,
            ProductServiceImpl productService,
            ClientService clientService
    ) {
        this.rentHistoryRepo=rentHistoryRepo;
        this.productWarehouseService = productWarehouseService;
        this.productService = productService;
        this.clientService = clientService;
    }

    @Override
    public List<RentHistory> getRentHistoryByClientId(Long clientId) {
        List<RentHistory> rentHistoryList = rentHistoryRepo.getRentHistoryByClientId(clientId);
        if(rentHistoryList == null || rentHistoryList.size() == 0) {
            throw new RuntimeException("Rent history not found");
        }
        return rentHistoryRepo.getRentHistoryByClientId(clientId);
    }

    @Override
    public RentHistory createRentEntry(Long clientId, Long productId) {

        List<ProductWarehouse> productWarehouse = productWarehouseService.getProductWarehouseByProductIdAndIsAvailable(productId, true);
        if (productWarehouse.size() == 0) {
            throw new RuntimeException("Products not available");
        }
        ProductWarehouse product = productWarehouse.get(0);
        product.setIsAvailable(false);

        RentHistory rentHistory = new RentHistory();
        rentHistory.setClientId(clientId);
        rentHistory.setRentStartDate(Instant.now());
        rentHistory.setProductWarehouseId(product.getId());

        productWarehouseService.updateProductWarehouse(product);

        return rentHistoryRepo.save(rentHistory);
    }

    @Override
    public RentHistory finishRentEntry(Long rentedProductId){
        RentHistory rentHistory = rentHistoryRepo.getById(rentedProductId);
        Instant startDate = rentHistory.getRentStartDate();
        Instant endDate = Instant.now();
        Long productWarehouseId = rentHistory.getProductWarehouseId();
        ProductWarehouse productWarehouse = productWarehouseService.getProductWarehouseById(productWarehouseId);
        Product product = productService.getProductById(productWarehouse.getProductId());
        BigDecimal priceByMinute = product.getPrice();
        BigDecimal minutes = BigDecimal.valueOf(ChronoUnit.MINUTES.between(startDate, endDate));
        BigDecimal costs = priceByMinute.multiply(minutes);
        productWarehouse.setIsAvailable(true);
        rentHistory.setRentEndDate(endDate);
        rentHistory.setCost(costs);
        productWarehouseService.updateProductWarehouse(productWarehouse);
        return rentHistoryRepo.save(rentHistory);
    }

    @Override
    public List<RentHistory> getRentHistoryByClientIdAndMonth(Long clientId, Integer month) {
        List<RentHistory> rentHistories = rentHistoryRepo.getRentHistoryByClientIdAndMonth(clientId, month);
        if(rentHistories == null || rentHistories.size() == 0){
            throw new RuntimeException("Rent history not found");
        }
        return rentHistoryRepo.getRentHistoryByClientIdAndMonth(clientId, month);
    }
}
