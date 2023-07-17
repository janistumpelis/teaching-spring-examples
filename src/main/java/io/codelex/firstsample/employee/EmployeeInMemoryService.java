package io.codelex.firstsample.employee;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;

public class EmployeeInMemoryService implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeInMemoryService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(String name) {
        Random r = new Random();
        Integer newID = r.nextInt(1000);
        Employee employee = new Employee(newID, name);
        employeeRepository.saveEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee findEmployeeById(Integer empId) {
        return employeeRepository.getAllEmployees()
                .stream()
                .filter(e -> e.getId().equals(empId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found by ID"));

    }
}
