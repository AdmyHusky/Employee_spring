package com.example.employee2.Services;

import com.example.employee2.Model.Employee;
import com.example.employee2.Model.ErrorResponse;
import com.example.employee2.Repository.EmployeeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) throws Exception {
        if(employee.getfName()== null || employee.getfName().isEmpty()){
            throw new Exception("first name must be null");
        }else if(employee.getlName()== null || employee.getlName().isEmpty()){
            throw new Exception("last name must be null");
        }else if(employee.getAge()<=0){
            throw new Exception("Age is a positive integer");
        }
        employeeRepository.save(employee);
    }

    public List<Employee> allEmployee() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(long id) throws Exception {
        findIdEmployee(id);
        employeeRepository.deleteById(id);
    }

    public Employee findIdEmployee(long id) throws Exception {
        /*if(employeeRepository.findById(id) == null){
            //throw new Exception("record not found");
            Optional<Employee> optional  = employeeRepository.findById(id);
            Employee employee = optional.get();
            ErrorResponse<Employee> response = new ErrorResponse<>();
            response.setMessage("Record not found");
            return ResponseEntity.ok(response);
        }*/

        return employeeRepository.findById(id).orElseThrow(()->new NotFoundException("Record not found"));

        /*Optional<Employee> optional  = employeeRepository.findById(id);
        Employee employee = optional.get();

        SuccessResponse<Employee> response = new SuccessResponse<>();
        response.setData(employee);
        return ResponseEntity.ok(response);*/
        //return ResponseEntity.ok(employeeRepository.findById(id));
    }

    public void putEmployee(Employee employee) throws Exception {
        findIdEmployee(employee.getId());
        if(employee.getfName()== null || employee.getfName().isEmpty()){
            throw new Exception("first name must be null");
        }else if(employee.getlName()== null || employee.getlName().isEmpty()){
            throw new Exception("last name must be null");
        }else if(employee.getAge()<=0){
            throw new Exception("Age is a positive integer");
        }
        employeeRepository.save(employee);
    }
}
