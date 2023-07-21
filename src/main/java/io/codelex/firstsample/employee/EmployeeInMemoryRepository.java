package io.codelex.firstsample.employee;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeInMemoryRepository {

    //Bad idea because of concurrency
    private final List<Employee> employeeList;

    public EmployeeInMemoryRepository() {
        this.employeeList = new ArrayList<>();
    }

    public void saveEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

}
