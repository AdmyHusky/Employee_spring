package com.example.employee2.Controller;

import com.example.employee2.Model.Employee;
import com.example.employee2.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/Hello")
    public String hello(){
        return "Hello Netto";
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "insert complete";
    }

    @GetMapping("/getall")
    public List<Employee> allEmployee(){
        return employeeService.allEmployee();
    }

    @DeleteMapping("/delete/")
    public String deleteEmployee(@RequestParam(value="id")long id) {
        employeeService.deleteEmployee(id);
        return "delete complete";
    }

    @GetMapping("/find/")
    public Optional<Employee> findIdEmployee(@RequestParam(value="id")long id){
        return employeeService.findIdEmployee(id);
    }

    @PutMapping("/put")
    public String putEmployee(@RequestBody Employee employee) {
        employeeService.putEmployee(employee);
        return "update complete";
    }

}
