package com.Customer.department_service.dao;

import com.Customer.department_service.Entity.DepartmentEntity;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository< DepartmentEntity,Long> {
    
}
