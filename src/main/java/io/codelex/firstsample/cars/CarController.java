package io.codelex.firstsample.cars;

import io.codelex.firstsample.cars.request.CreateCarRequest;
import io.codelex.firstsample.cars.response.ListCarsResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    Logger logger = LoggerFactory.getLogger(CarController.class);

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCar(@Valid @RequestBody CreateCarRequest request) {
        logger.info("Car was saved: " + request.getBrand() + " " + request.getModel());
        carService.saveCar(request);
    }

    @GetMapping("/list")
    public ListCarsResponse listCars() {
        return carService.listCars();
    }

}
