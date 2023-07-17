package io.codelex.firstsample.cars.dto;

import io.codelex.firstsample.cars.domain.Car;

public class CarDTO {

    public Long id;
    public String brand;
    public String model;
    public Integer mileage;

    public CarDTO(Long id, String brand, String model, Integer mileage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
    }

    public static CarDTO fromDomain(Car car) {
        return new CarDTO(car.getId(), car.getBrand(), car.getModel(), car.getMileage());
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

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}
