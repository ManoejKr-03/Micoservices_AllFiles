package com.Employee.Employee.controller;

import java.util.List;

import com.Employee.Employee.Entity.Employee;
import com.Employee.Employee.services.ServiceEmployee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

        @Autowired
        ServiceEmployee serviceEmployee;

    @PostMapping("/Employee")
    public Employee addEmployeeDetails(@RequestBody Employee employee)
    {
        LOG.info("get all employee");
        return serviceEmployee.addEmployee(employee);
    }
    @Autowired
   public static final Logger LOG = LoggerFactory.getLogger(Employee.class);

    @GetMapping("/Employee/{did}")
    public Employee getEmployeeById(@PathVariable long did)
    {
        LOG.info("get a employee");
        return serviceEmployee.getEmployeeById(did);
    }

    @GetMapping("/Employee/department/{did}")
    public List<Employee> getEmployeeByDepartmentId(@PathVariable long did)
    {
        LOG.info("get a employee by department id");
        return serviceEmployee.getEmployeeByDepartmentById(did);
    }

    @PutMapping("/Employee")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        LOG.info("update a employee");
        return serviceEmployee.updateEmployee(employee);
    }

    @DeleteMapping("Employee/{did}")
    public void deleteEmployee(@PathVariable long id)
    {
        LOG.info("delete the employee");
        serviceEmployee.deleteEmployee(id);
    }
    
}
