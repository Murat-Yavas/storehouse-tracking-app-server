package com.devtech.StorehouseTrackingApp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String userName;

    @OneToMany(mappedBy = "user")
    List<Storehouse> storehouse;
}
