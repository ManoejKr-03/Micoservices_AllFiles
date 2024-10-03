package com.Employee.Employee.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.Employee.Employee.Entity.Employee;
import com.Employee.Employee.Repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEmployee {

    @Autowired 
    public  EmployeeRepo EmployeeRepository;

    public Employee addEmployee(Employee employeeObj)
    {
        return EmployeeRepository.save(employeeObj);
    }

    public Employee getEmployeeById(long id)
    {
        Optional<Employee> fetchedEmployee = EmployeeRepository.findById(id);

        if(fetchedEmployee.isPresent())
        return fetchedEmployee.get();
        else
        return null;
    }

    public Employee updateEmployee(Employee employee)
    {
        Optional<Employee> fetchedEmployee = EmployeeRepository.findById(employee.getEmpId());

        if(fetchedEmployee.isPresent())
        return EmployeeRepository.saveAndFlush(employee);
        else
        return null;

    }

    public void deleteEmployee(long id)
    {
        Optional<Employee>deleteOne= EmployeeRepository.findById(id);
        return;
    }

    public List<Employee> getEmployeeByDepartmentById(long did) {
        List<Employee>allEmp = EmployeeRepository.findAll();
        List<Employee>AllEmployeeBydept = allEmp.stream().filter((e) -> e.getDeptId()==did).collect(Collectors.toList());

        return AllEmployeeBydept;
    }
    
}
