package com.comarch.appcomarch.repositories;

import com.comarch.appcomarch.model.RentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RentHistoryRepo extends JpaRepository<RentHistory, Long> {

    List<RentHistory> getRentHistoryByClientId(Long clientId);

    @Query(nativeQuery = true, value = "SELECT * FROM rent_history WHERE MONTH(rent_start_date) =:month and client_id =:clientId")
    List<RentHistory> getRentHistoryByClientIdAndMonth(Long clientId, Integer month);

}
