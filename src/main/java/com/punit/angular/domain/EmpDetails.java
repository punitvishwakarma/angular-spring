package com.punit.angular.domain;
// Generated Oct 27, 2018 2:05:41 PM by Hibernate Tools 4.3.1



/**
 * EmpDetails generated by hbm2java
 */
public class EmpDetails  implements java.io.Serializable {


     private Integer empId;
     private String empName;
     private String empEmail;
     private String empGender;
     private String empAddress;

    public EmpDetails() {
    }

    public EmpDetails(String empName, String empEmail, String empGender, String empAddress) {
       this.empName = empName;
       this.empEmail = empEmail;
       this.empGender = empGender;
       this.empAddress = empAddress;
    }
   
    public Integer getEmpId() {
        return this.empId;
    }
    
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return this.empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpEmail() {
        return this.empEmail;
    }
    
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }
    public String getEmpGender() {
        return this.empGender;
    }
    
    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }
    public String getEmpAddress() {
        return this.empAddress;
    }
    
    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }




}


