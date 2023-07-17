package io.codelex.firstsample.cars.request;

import io.codelex.firstsample.cars.domain.Driver;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateCarRequest {

    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @Min(0)
    @Max(1000000)
    @NotNull
    private Integer mileage;

    @Valid
    @NotNull
    private Driver driver;

    public CreateCarRequest() {
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
