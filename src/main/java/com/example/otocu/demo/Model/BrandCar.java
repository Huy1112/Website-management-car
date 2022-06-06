package com.example.otocu.demo.Model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "brand_car")
@Entity
public class BrandCar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "picture")
    private String picture;
}
