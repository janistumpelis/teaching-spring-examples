package io.codelex.firstsample.cars;

import io.codelex.firstsample.cars.domain.Car;
import io.codelex.firstsample.cars.domain.Driver;
import io.codelex.firstsample.cars.dto.CarDTO;
import io.codelex.firstsample.cars.request.CreateCarRequest;
import io.codelex.firstsample.cars.response.ListCarsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    CarService carService;

    @InjectMocks
    CarController carController;

    @Test
    void listCars() {
        //Given
        List<CarDTO> expectedList = new ArrayList<>();
        CarDTO car = new CarDTO(1L, "Volvo", "V70", 250000);
        expectedList.add(car);
        ListCarsResponse mockResponse = new ListCarsResponse(expectedList);
        Mockito.when(carService.listCars()).thenReturn(mockResponse);

        ListCarsResponse actualResponse = carController.listCars();

        Mockito.verify(carService).listCars();
        Assertions.assertEquals(1, actualResponse.getCars().size());
        Assertions.assertEquals(actualResponse.getCars().get(0), car);
    }

    @Test
    void saveCar() {
        CreateCarRequest request = new CreateCarRequest();
        request.setBrand("Volvo");
        request.setModel("V70");
        request.setMileage(250000);
        request.setDriver(new Driver());

        carController.saveCar(request);

        Mockito.verify(carService).saveCar(request);
    }
}