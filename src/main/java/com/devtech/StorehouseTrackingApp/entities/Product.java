package com.devtech.StorehouseTrackingApp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double entryPrice;
    private int quantity;
    private String productName;

    private String entryDate;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "storehouse_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Storehouse storehouse;
}
