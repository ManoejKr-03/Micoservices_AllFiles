package com.Customer.department_service.controller;

import java.util.List;

import com.Customer.department_service.Entity.DepartmentPojo;
import com.Customer.department_service.Entity.EmployeePojo;
import com.Customer.department_service.service.DepartmentService;

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
import org.springframework.web.client.RestClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DepartmentController {

    
   public DepartmentService departmentService;

   @Autowired
   public static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);

   @Autowired
   public DepartmentController(DepartmentService departmentService)
   {
       this.departmentService = departmentService;
   }


   @GetMapping("/department")
   public List<DepartmentPojo> getAllDepartment()
   {
        LOG.info("get all department");
       return departmentService.getAllDepartments();
   }

   @GetMapping("/department/{did}")
   @CircuitBreaker(name="ciremp", fallbackMethod = "empFallBack")
   public DepartmentPojo getADepartmentById(@PathVariable("did") long id)
   {
       LOG.info(" get a employee by departmentid");
       DepartmentPojo deptpojo =  departmentService.getADepartment(id);
       RestClient restclient = RestClient.create();
///Employee/department/{did}
      List<EmployeePojo>allemps =  restclient
                .get()
                .uri("http://localhost:8082/Employee/department/" + id) // complete it
                .retrieve()
                .body(List.class);


            deptpojo.setAllEmployees(allemps);
            return deptpojo;
   }

   //when the above staff is not working for (n times) ( it will be opened and return )
   public DepartmentPojo empFallBack()
   {
       return new DepartmentPojo(0,"failback",null);
   }

   @PostMapping("/department")
   public DepartmentPojo addADepartment(@RequestBody DepartmentPojo departmentPojo)
   {
        LOG.info("  addDepartment");
       return departmentService.addDepartment(departmentPojo);
   }

   @PutMapping("/department")
   public DepartmentPojo updateDepartment(@RequestBody DepartmentPojo departmentPojo)
   {
    LOG.info("UPDATE department");
       return departmentService.updateDepartment(departmentPojo);
   }

   @DeleteMapping("/department/{did}")
   public void removeDepartment(@PathVariable("did") long id)
   {
    LOG.info("remove the department");
       departmentService.deleteDepartment(id);
   }
    
}
