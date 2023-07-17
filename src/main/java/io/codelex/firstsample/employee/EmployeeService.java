package io.codelex.firstsample.employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(String name);

    List<Employee> getAllEmployees();

    Employee findEmployeeById(Integer empId);

}
