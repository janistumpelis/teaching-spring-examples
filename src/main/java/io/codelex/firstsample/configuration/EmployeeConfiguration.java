package io.codelex.firstsample.configuration;

import io.codelex.firstsample.employee.EmployeeDatabaseService;
import io.codelex.firstsample.employee.EmployeeInMemoryService;
import io.codelex.firstsample.employee.EmployeeRepository;
import io.codelex.firstsample.employee.EmployeeService;
import io.codelex.firstsample.weather.WeatherApiClient;
import io.codelex.firstsample.weather.WeatherApiClientNew;
import io.codelex.firstsample.weather.WeatherApiClientOld;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

@Configuration
public class EmployeeConfiguration {


    @Bean
    @ConditionalOnProperty(prefix="employee", name="service.version", havingValue = "in-memory")
    public EmployeeService getInMemoryVersion() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        return new EmployeeInMemoryService(employeeRepository);
    }


    @Bean
    @ConditionalOnProperty(prefix="employee", name="service.version", havingValue = "database")
    public EmployeeService getDatabaseVersion() {
        return new EmployeeDatabaseService();
    }
}
