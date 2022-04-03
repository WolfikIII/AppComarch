package com.comarch.appcomarch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "products")
@Setter
@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    @Column(name = "productId")
    private Long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "price", length = 10, nullable = false)
    private BigDecimal price;

    @OneToMany()
    @JoinColumn(name = "productId")
    private List<ProductWarehouse> productWarehouse;

}
