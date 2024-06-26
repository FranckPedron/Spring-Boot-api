package com.franckycorp.api.controller;

import com.franckycorp.api.model.Employee;
import com.franckycorp.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Create - Add a new employee
     * @param employee - An object employee
     * @return - The employee object saved
     */
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * Read - Get all employess
     * @return - An Iterable object of Employee fullfilled
     */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * Read - Get one employee
     * @param id - The id of the employee
     * @return - An Employee object fullfilled
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") final Long id) {
        return employeeService.getEmployee(id);
    }

    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param employee - The employee object updated
     * @return - An updated employee object
     */
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {

        Employee currentEmployee = employeeService.getEmployee(id);

            String firstName = employee.getFirstName();
            if (firstName != null) {
                currentEmployee.setFirstName(firstName);
            }

            String lastName = employee.getLastName();
            if (lastName != null) {
                currentEmployee.setLastName(lastName);
            }

            String mail = employee.getMail();
            if (mail != null) {
                currentEmployee.setMail(mail);
            }

            String password = employee.getPassword();
            if (password != null) {
                currentEmployee.setPassword(password);
            }

            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;
    }

    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final  Long id) {
        employeeService.deleteEmployee(id);
    }
}
