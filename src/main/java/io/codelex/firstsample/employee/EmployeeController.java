package io.codelex.firstsample.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Value("${myApp.greeting:Sveiki}")
    private String greeting;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path ="/text")
    public String getText() {
        return greeting;
    }


    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //Data is passed in request inside in request's body (as plain text, as JSON etc.)
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody String name) {
        logger.info("Person was saved: " + name);
        employeeService.saveEmployee(name);
    }

    //http://localhost:8080/employee/find/405
    @GetMapping("/find/{employeeId}")
    public Employee findEmployee(@PathVariable("employeeId") Integer empId) {
        return employeeService.findEmployeeById(empId);
    }

    //http://localhost:8080/employee/findWithRequestParam?eId=969
    @GetMapping("/findWithRequestParam")
    public Employee findEmployeeByRequestParam(@RequestParam("eId") Integer empId) {
        return employeeService.findEmployeeById(empId);
    }

    //http://localhost:8080/employee/search?name=John
    @GetMapping("/search")
    public List<Employee> searchEmployeesByName(@RequestParam("name") String name) {
        return employeeService.searchEmployeesByName(name);
    }

    @GetMapping("/testerror")
    public void makeError() {
        try {
            int b = 100;
            int c = 0;
            int d = b / c;
        } catch (ArithmeticException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Division by 0", e);
        }


        String a = null;
        a.length();
    }

}
