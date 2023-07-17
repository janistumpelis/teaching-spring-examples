package io.codelex.firstsample.cars.response;

import io.codelex.firstsample.cars.domain.Car;
import io.codelex.firstsample.cars.dto.CarDTO;

import java.util.List;
import java.util.Objects;

public class ListCarsResponse {

    private List<CarDTO> cars;

    public ListCarsResponse(List<CarDTO> cars) {
        this.cars = cars;
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListCarsResponse that = (ListCarsResponse) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
