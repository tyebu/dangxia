package com.wxc.dangxia.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
/**
 * 员工表实体
 *
 * @author Star.Wu
 * @date 2019/05/07
 */
public class Employee implements Serializable{
    private Integer empId;
    private String empLoginName;
    private String empPassword;
    private String empName;
    private Boolean empSex;
    private String empPhone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    private Integer operId;
    private Integer empStatus;
    private Boolean isAdmin;
    private Boolean isDel;

    public Employee() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpLoginName() {
        return empLoginName;
    }

    public void setEmpLoginName(String empLoginName) {
        this.empLoginName = empLoginName;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    public Integer getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(Integer empStatus) {
        this.empStatus = empStatus;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public Boolean getEmpSex() {
        return empSex;
    }

    public void setEmpSex(Boolean empSex) {
        this.empSex = empSex;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}