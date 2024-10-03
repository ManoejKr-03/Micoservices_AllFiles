package com.Customer.department_service.Entity;

 
import java.util.List;

public class DepartmentPojo {

    private long deptId;
    private String deptName;
    private List<EmployeePojo>allEmployee;

    
    public DepartmentPojo() {
    }
    
    public List<EmployeePojo> getAllEmployee() {
        return allEmployee;
    }

    public void setAllEmployee(List<EmployeePojo> allEmployee) {
        this.allEmployee = allEmployee;
    }

    public DepartmentPojo(long deptId, String deptName, List<EmployeePojo> allEmployee) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.setAllEmployee(allEmployee);
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
    public void setAllEmployees(List<EmployeePojo> allemps) {
        setAllEmployee(allemps);
    }


    
}
