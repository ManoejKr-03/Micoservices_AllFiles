package com.Customer.department_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 

 

@Entity
@Table(name="department_details")
public class DepartmentEntity {
    
    @Id
    @Column(name="dept_id")
    private long deptId;

    @Column(name="dept_name")
    private String deptName;
    

    public DepartmentEntity() {
    }

    public DepartmentEntity(long deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    


}
