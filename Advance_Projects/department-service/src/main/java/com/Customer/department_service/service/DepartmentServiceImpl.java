package com.Customer.department_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.Customer.department_service.Entity.DepartmentEntity;
import com.Customer.department_service.Entity.DepartmentPojo;
import com.Customer.department_service.dao.DepartmentRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    
    DepartmentRepository deptrepo;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository deptrepo)
    {
        this.deptrepo = deptrepo;
    }


    @Override
    public List<DepartmentPojo> getAllDepartments() {
         List<DepartmentEntity> allDeptEntity = deptrepo.findAll();
         List<DepartmentPojo> allDeptPojo  = new ArrayList<>();

         allDeptEntity.stream().forEach((eachObj)->{
            DepartmentPojo deptPojo = new DepartmentPojo();

            BeanUtils.copyProperties(eachObj,deptPojo);
            allDeptPojo.add(deptPojo);

         });

         return allDeptPojo;
        
    }

    @Override
    public DepartmentPojo getADepartment(long deptId) {
        // TODO Auto-generated method stub
        Optional<DepartmentEntity> fetchedDeptEntity = deptrepo.findById(deptId);

        DepartmentPojo departpojo = new DepartmentPojo();
        if(fetchedDeptEntity.isPresent())
        {
            BeanUtils.copyProperties(fetchedDeptEntity.get(), departpojo);
        }

        return departpojo;
        
        

    }

    @Override
    public DepartmentPojo addDepartment(DepartmentPojo newpojo) {
        // TODO Auto-generated method stub
        DepartmentEntity deptEntity = new DepartmentEntity();
        BeanUtils.copyProperties(newpojo, deptEntity);
        deptrepo.save(deptEntity);
        return newpojo;
        
    }

    @Override
    public DepartmentPojo updateDepartment(DepartmentPojo newpojo) {
        // TODO Auto-generated method stub
        DepartmentEntity deptEntity = new DepartmentEntity();
        BeanUtils.copyProperties(newpojo, deptEntity);
        deptrepo.saveAndFlush(deptEntity);

        return newpojo;
         
    }

    @Override
    public void deleteDepartment(long id) {
        // TODO Auto-generated method stub
        Optional<DepartmentEntity>receivedEntity = deptrepo.findById(id);
        deptrepo.delete(receivedEntity.get());
        
    }
    
}
