package io.codelex.firstsample.cars.domain;

import jakarta.validation.constraints.NotBlank;

public class Driver {

    @NotBlank
    private String name;
    @NotBlank
    private String lastName;

    public Driver() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
