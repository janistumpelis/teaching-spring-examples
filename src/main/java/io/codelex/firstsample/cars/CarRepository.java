package io.codelex.firstsample.cars;

import io.codelex.firstsample.cars.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {

    private List<Car> savedCars = new ArrayList<>();

    public void saveCar(Car car) {
        this.savedCars.add(car);
    }

    public List<Car> listCars() {
        return savedCars;
    }

}
