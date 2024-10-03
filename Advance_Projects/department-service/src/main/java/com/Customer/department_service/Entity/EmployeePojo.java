package com.Customer.department_service.Entity;

 

 
public class EmployeePojo {
     
    private long empId;
    private String name;
    private long deptId;
    public EmployeePojo() {
    }
    public EmployeePojo(long empId, String name, long deptId) {
        this.empId = empId;
        this.name = name;
        this.deptId = deptId;
    }
    public long getEmpId() {
        return empId;
    }
    public void setEmpId(long empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getDeptId() {
        return deptId;
    }
    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    



     
    
}
