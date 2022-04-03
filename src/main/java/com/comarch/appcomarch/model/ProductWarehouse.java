package com.comarch.appcomarch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productWarehouses")
@Entity
public class ProductWarehouse {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productWarehouseId")
    private Long id;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "availibility")
    private Boolean isAvailable;


}
