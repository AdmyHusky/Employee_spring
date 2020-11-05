package com.example.employee2.Controller;

import com.example.employee2.Model.Employee;
import com.example.employee2.Model.ErrorResponse;
import com.example.employee2.Services.EmployeeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/employee")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/Hello")
    public String hello(){
        return "Hello Netto";
    }

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        try {
            employeeService.addEmployee(employee);
            return ResponseEntity.ok("success");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
        }
    }

    @GetMapping
    public List<Employee> allEmployee(){
        return employeeService.allEmployee();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return "delete complete";
    }

    @GetMapping("/{id}")
    //Optional<Employee>
    public ResponseEntity findIdEmployee(@PathVariable long id) throws Exception {
        try {
            employeeService.findIdEmployee(id);
            return ResponseEntity.ok(employeeService.findIdEmployee(id));
        }catch (NotFoundException ex){
            return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
        }
    }

    @PutMapping
    public String putEmployee(@RequestBody Employee employee) {
        employeeService.putEmployee(employee);
        return "update complete";
    }

}
