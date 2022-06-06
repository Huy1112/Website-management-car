package com.example.otocu.demo.ModelData;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Data
public class Oder {


    @NotEmpty(message = "The name of car can't be null")
    private String nameCar;

//    @NotEmpty(message = "The created date of car can't be null")
    private int create_car;

    @NotEmpty(message = "The nation of car can't be null")
    private String nation;

    @NotEmpty(message = "The form of car can't be null")
    private String form;

    @NotEmpty(message = "The state of car can't be null")
    private String state;

    @NotEmpty(message = "The gear of car can't be null")
    private String gear;

    @NotEmpty(message = "The fuel of car can't be null")
    private String fuel;

    @NotEmpty(message = "The gone of car can't be null")
    private String gone;

    @NotEmpty(message = "The quality of car can't be null")
    private String quality;

//    @NotEmpty(message = "The price of car can't be null")
    private int price;

    @NotEmpty(message = "The city of car can't be null")
    private String city;

    @NotNull
    private int brand;

    @NotEmpty(message = "The title of new can't be null")
    private String title;

    @NotEmpty(message = "The description of new can't be null")
    private String des;

    private String support;
    @NotFound
    private MultipartFile file1;
    private MultipartFile file2;
    private MultipartFile file3;

    private String nameUser;

    public Oder(String nameCar, int create_car, String nation, String form, String state, String gear, String fuel, String gone, String quality, int price, String city, int brand, String title, String des, String support, MultipartFile file1, MultipartFile file2, MultipartFile file3, String nameUser) {
        this.nameCar = nameCar;
        this.create_car = create_car;
        this.nation = nation;
        this.form = form;
        this.state = state;
        this.gear = gear;
        this.fuel = fuel;
        this.gone = gone;
        this.quality = quality;
        this.price = price;
        this.city = city;
        this.brand = brand;
        this.title = title;
        this.des = des;
        this.support = support;
        this.file1 = file1;
        this.file2 = file2;
        this.file3 = file3;
        this.nameUser = nameUser;
    }

    public Oder(String nameCar, int create_car, String nation, String form, String state, String gear, String fuel, String gone, String quality, int price, String city, int brand, String title, String des, String support, String nameUser) {
        this.nameCar = nameCar;
        this.create_car = create_car;
        this.nation = nation;
        this.form = form;
        this.state = state;
        this.gear = gear;
        this.fuel = fuel;
        this.gone = gone;
        this.quality = quality;
        this.price = price;
        this.city = city;
        this.brand = brand;
        this.title = title;
        this.des = des;
        this.support = support;
        this.nameUser = nameUser;
    }
}
