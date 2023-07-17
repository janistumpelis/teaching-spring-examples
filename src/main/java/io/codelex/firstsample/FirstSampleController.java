package io.codelex.firstsample;

import io.codelex.firstsample.configuration.WeatherApiConfig;
import io.codelex.firstsample.employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.Random;

@RestController
public class FirstSampleController {

    private WeatherApiConfig weatherApiConfig;

    public FirstSampleController(WeatherApiConfig weatherApiConfig) {
        this.weatherApiConfig = weatherApiConfig;
    }

    @GetMapping("/text")
    public String getText() {
        return "==============LOVE IS IN THE AIR==============";
    }

    @PostMapping("/employee")
    public Employee getTextWithPost(@RequestBody String name) {
        Random r = new Random();
        Employee employee = new Employee(r.nextInt(1000), name);
        return employee;
    }

    @GetMapping("/weatherconfig")
    public String getWeatherConfig() {
        return weatherApiConfig.toString();
    }

}
