package io.codelex.firstsample.cars;

import io.codelex.firstsample.cars.domain.Car;
import io.codelex.firstsample.cars.dto.CarDTO;
import io.codelex.firstsample.cars.request.CreateCarRequest;
import io.codelex.firstsample.cars.response.ListCarsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

@Service
public class CarService {

    private final CarRepository carRepository;

    private Logger logger = LoggerFactory.getLogger(CarService.class);

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public synchronized void saveCar(CreateCarRequest request) {
        long lastUsedId = carRepository.listCars().stream().mapToLong(Car::getId).max().orElse(0);
        Long newId = lastUsedId + 1;
        LocalDateTime dateCreated = LocalDateTime.now();
        Car car = new Car(newId, request.getBrand(), request.getModel(), request.getMileage(), dateCreated);
        logger.info(request.getDriver().toString() + " car was saved with this driver");
        carRepository.saveCar(car);
    }

    public ListCarsResponse listCars() {
        return new ListCarsResponse(carRepository.listCars().stream().map(CarDTO::fromDomain).toList());
    }

    public List<Car> findCars(String text) {
        return carRepository.listCars().stream().filter(c ->
                Car.fieldAccessFunc.stream().anyMatch(f -> f.apply(c).contains(text))
        ).toList();
    }
}
