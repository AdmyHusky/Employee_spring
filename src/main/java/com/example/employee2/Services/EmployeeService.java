package com.example.employee2.Services;

import com.example.employee2.Model.Employee;
import com.example.employee2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> allEmployee() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> findIdEmployee(long id) {
        return employeeRepository.findById(id);
    }

    public void putEmployee(Employee employee) {
        Employee emp = new Employee();
        emp = employee;
        employeeRepository.save(employee);
    }
}
