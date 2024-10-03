package com.Customer.department_service.service;

import java.util.List;

import com.Customer.department_service.Entity.DepartmentPojo;

public interface DepartmentService {

  public  List<DepartmentPojo> getAllDepartments();
   public DepartmentPojo getADepartment(long deptId);
   public DepartmentPojo addDepartment(DepartmentPojo newpojo);
   public  DepartmentPojo updateDepartment(DepartmentPojo newpojo);
   public  void deleteDepartment(long id);


    
}
