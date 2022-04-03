package com.comarch.appcomarch.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;


@Data
@NoArgsConstructor
@Table(name = "rentHistory")
@Entity
public class RentHistory {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rentHistoryId")
    private Long  id;

    @Column(name = "clientId")
    private Long clientId;

    @Column(name = "productWarehouseId")
    private Long productWarehouseId;

    @Column(name = "rentStartDate")
    private Instant rentStartDate;

    @Column(name = "rentEndDate")
    private Instant rentEndDate;

    @Column(name = "costs")
    private BigDecimal cost;

}
