package io.codelex.firstsample.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    EmployeeInMemoryRepository employeeInMemoryRepository;

    @InjectMocks
    EmployeeInMemoryService employeeService;

    private List<Employee> testEmployeeList = Arrays.asList(
            new Employee(1, "John"),
            new Employee(11, "Edgar"),
            new Employee(10, "Mark")
    );

    @Test
    void findEmployeeById() {
        Integer testEmpId = 10;
        Mockito.when(employeeInMemoryRepository.getAllEmployees()).thenReturn(testEmployeeList);
        Employee returnedEmployee = employeeService.findEmployeeById(testEmpId);
        Assertions.assertEquals("Mark", returnedEmployee.getName());
        Assertions.assertEquals(10, returnedEmployee.getId());
    }

    @Test
    void findEmployeeByIdTestException() {
        Integer testEmpId = 22;
        Mockito.when(employeeInMemoryRepository.getAllEmployees()).thenReturn(testEmployeeList);
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            employeeService.findEmployeeById(testEmpId);
        });
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());

    }
}