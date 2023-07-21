package io.codelex.firstsample;

import io.codelex.firstsample.employee.EmployeeController;
import io.codelex.firstsample.employee.EmployeeInMemoryRepository;
import io.codelex.firstsample.weather.WeatherController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class FirstSampleApplicationTests {

    @Autowired
    EmployeeController employeeController;
    @Autowired
    EmployeeInMemoryRepository employeeInMemoryRepository;
    @Autowired
    WeatherController weatherController;
    @Autowired
    MockMvc mvc;
    

    @Test
    void employeeTest() {
        //Given
        String employeeName = "John";
        //When
        employeeController.saveEmployee(employeeName);
        //Then
        String savedName = employeeInMemoryRepository.getAllEmployees().get(0).getName();
        Assertions.assertEquals(employeeName, savedName);
    }

    //Wrong test because it actually calls external API
    @Test
    void weatherTest() {
        String currentWeather = weatherController.getCurrentWeather();
        Assertions.assertFalse(currentWeather.isBlank());
    }

}
