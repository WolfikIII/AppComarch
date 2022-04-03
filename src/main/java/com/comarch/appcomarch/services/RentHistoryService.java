package com.comarch.appcomarch.services;

import com.comarch.appcomarch.model.RentHistory;

import java.util.List;

public interface RentHistoryService {

    List<RentHistory> getRentHistoryByClientId(Long clientId);

    RentHistory createRentEntry(Long clientId, Long productId);

    RentHistory finishRentEntry(Long rentedProductId);

    List<RentHistory> getRentHistoryByClientIdAndMonth(Long clientId, Integer month);
}
