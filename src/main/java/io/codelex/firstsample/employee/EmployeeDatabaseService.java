package io.codelex.firstsample.employee;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class EmployeeDatabaseService implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeDatabaseService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void saveEmployee(String name) {
        Employee newEmployee = new Employee();
        newEmployee.setName(name);
        employeeRepository.save(newEmployee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Integer empId) {
        return employeeRepository.findEmployeeById(empId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.searchByName(name);
    }


}
