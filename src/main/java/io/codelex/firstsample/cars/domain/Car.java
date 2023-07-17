package io.codelex.firstsample.cars.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

//this class will match DB table
public class Car {

    private Long id;
    private String brand;
    private String model;
    private Integer mileage;
    private LocalDateTime dateCreated;

    public static List<Function<Car, String>> fieldAccessFunc = Arrays.asList(
            Car::getBrand,
            Car::getModel,
            c -> c.getMileage().toString(),
            c -> c.getDateCreated().toString(),
            c -> c.getId().toString()
    );

    public Car(Long id, String brand, String model, Integer mileage, LocalDateTime dateCreated) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}
