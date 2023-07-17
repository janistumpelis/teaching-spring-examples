package io.codelex.firstsample.cars;

import io.codelex.firstsample.cars.domain.Car;
import io.codelex.firstsample.cars.domain.Driver;
import io.codelex.firstsample.cars.request.CreateCarRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarService carService;

    @Captor
    ArgumentCaptor<Car> carCaptor;

    @Test
    public void testSaveCar() {
        //Given
        CreateCarRequest request = new CreateCarRequest();
        request.setBrand("Volvo");
        request.setModel("V70");
        request.setMileage(250000);
        request.setDriver(new Driver());
        Mockito.when(carRepository.listCars()).thenReturn(List.of(
                new Car(123L, null, null, null, null)
        ));
        //When
        carService.saveCar(request);
        //Then
//              Mockito.verify(carRepository).saveCar(ArgumentMatchers.any(Car.class));
        Mockito.verify(carRepository).saveCar(carCaptor.capture());
        Car carThatWasSaved = carCaptor.getValue();
        Assertions.assertEquals(request.getBrand(), carThatWasSaved.getBrand());
        Assertions.assertEquals(request.getModel(), carThatWasSaved.getModel());
        Assertions.assertEquals(request.getMileage(), carThatWasSaved.getMileage());
        Assertions.assertEquals(124L, carThatWasSaved.getId());

    }

}
