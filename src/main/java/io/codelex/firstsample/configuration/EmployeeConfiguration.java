package io.codelex.firstsample.configuration;

import io.codelex.firstsample.employee.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {


    @Bean
    @ConditionalOnProperty(prefix="employee", name="service.version", havingValue = "in-memory")
    public EmployeeService getInMemoryVersion(EmployeeInMemoryRepository employeeInMemoryRepository) {
        return new EmployeeInMemoryService(employeeInMemoryRepository);
    }


    @Bean
    @ConditionalOnProperty(prefix="employee", name="service.version", havingValue = "database")
    public EmployeeService getDatabaseVersion(EmployeeRepository employeeRepository) {
        return new EmployeeDatabaseService(employeeRepository);
    }
}
