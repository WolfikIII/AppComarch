package com.comarch.appcomarch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "clients")
@Entity
public class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    @Column(name = "clientId")
    private Long id;

    @Column(name = "clientFirstName")
    private String firstName;

    @Column(name = "clientSecondName")
    private String secondName;

   @OneToMany()
   @JoinColumn(name = "clientId")
   private List<RentHistory> rentHistories;
}

