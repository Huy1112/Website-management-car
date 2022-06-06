package com.example.otocu.demo.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "car")
@Data
@ToString
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "create_car")
    private int create_car;
    @Column(name = "nation")
    private String nation;
    @Column(name = "form")
    private String form;
    @Column(name = "state")
    private String state;
    @Column(name = "gear")
    private String gear;
    @Column(name = "fuel")
    private String fuel;
    @Column(name = "gone")
    private String gone;
    @Column(name = "quality")
    private String quality;
    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "city")
    private Province city;

    @ManyToOne
    @JoinColumn(name = "brand")
    private BrandCar brand;

    @OneToMany(mappedBy = "car1",cascade = CascadeType.ALL)
    private List<PicCar> picCars;
    @OneToOne(mappedBy = "carNew",cascade = CascadeType.ALL)
    private New news;


    public Car(String name, int create_car, String nation, String form, String state, String gear, String fuel, String gone, String quality, int price) {
        this.name = name;
        this.create_car = create_car;
        this.nation = nation;
        this.form = form;
        this.state = state;
        this.gear = gear;
        this.fuel = fuel;
        this.gone = gone;
        this.quality = quality;
        this.price = price;
    }
}
