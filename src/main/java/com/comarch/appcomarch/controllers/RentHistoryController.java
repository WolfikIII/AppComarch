package com.comarch.appcomarch.controllers;

import com.comarch.appcomarch.model.RentHistory;
import com.comarch.appcomarch.services.ClientService;
import com.comarch.appcomarch.services.impl.ProductServiceImpl;
import com.comarch.appcomarch.services.impl.RentHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentHistory")
public class RentHistoryController {
    private RentHistoryServiceImpl rentHistoryService;
    private ClientService clientService;
    private ProductServiceImpl productService;

    @Autowired
    public RentHistoryController(RentHistoryServiceImpl rentHistoryService,
                                 ClientService clientService, ProductServiceImpl productService) {
        this.rentHistoryService=rentHistoryService;
        this.clientService = clientService;
        this.productService = productService;
    }

    @GetMapping("/byClientId")
    public List<RentHistory> getClientHistory(@RequestParam Long clientId){
        return rentHistoryService.getRentHistoryByClientId(clientId);
    }

    @PutMapping("/finish")
    public RentHistory finishRentEntry(@RequestParam Long rentedProductId){
        return rentHistoryService.finishRentEntry(rentedProductId);
    }

    @PostMapping("/create")
    public ResponseEntity<RentHistory> createRentEntry(@RequestParam Long clientId, @RequestParam Long productId) {
        return new ResponseEntity<>(rentHistoryService.createRentEntry(clientId, productId), HttpStatus.CREATED);
    }

    @GetMapping("/byClientIdAndMonth")
    public List<RentHistory> getRentHistoryByClientIdAndMonth(@RequestParam Long clientId, @RequestParam Integer month) {
        return rentHistoryService.getRentHistoryByClientIdAndMonth(clientId, month);
    }
}
