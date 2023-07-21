package io.codelex.firstsample.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;

public class EmployeeInMemoryService implements EmployeeService {

    private EmployeeInMemoryRepository employeeInMemoryRepository;

    public EmployeeInMemoryService(EmployeeInMemoryRepository employeeInMemoryRepository) {
        this.employeeInMemoryRepository = employeeInMemoryRepository;
    }

    public void saveEmployee(String name) {
        Random r = new Random();
        Integer newID = r.nextInt(1000);
        Employee employee = new Employee(newID, name);
        employeeInMemoryRepository.saveEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeInMemoryRepository.getAllEmployees();
    }

    public Employee findEmployeeById(Integer empId) {
        return employeeInMemoryRepository.getAllEmployees()
                .stream()
                .filter(e -> e.getId().equals(empId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found by ID"));

    }

    @Override
    public List<Employee> searchEmployeesByName(String name) {
        return null;
    }
}
