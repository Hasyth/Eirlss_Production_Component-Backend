package com.apiit.eirlss.productioncomponent.eirlss_production.Controllers;

import com.apiit.eirlss.productioncomponent.eirlss_production.Models.Employee;
import com.apiit.eirlss.productioncomponent.eirlss_production.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "/employees")

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Employee> getEmployees() {
        System.out.println("Fetching all products");
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/id")
    public Employee getEmployee(@PathVariable String id) {
        System.out.println("Fetching product one by one");
        return employeeRepository.findById(id).get();
    }

    @PostMapping(path = "/new")
    public Employee newEmployee(@RequestBody Employee employee) {

        Employee newemployee;
        newemployee = employeeRepository.save(employee);
        System.out.println(newemployee.getName()+ "is added ");

        return newemployee;
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeRepository.save(employee);

        return employee;
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployee(@PathVariable String id) {

        boolean flag;
        Employee category = getEmployee(id);
        if (category != null) {
            employeeRepository.deleteById(id);
            flag = true;
        } else {
            flag = false;

        }
        return flag;


    }

}
