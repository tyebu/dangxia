package com.wxc.dangxia.entity;

import lombok.Data;

import java.util.Date;
/**
 * 员工表实体
 *
 * @author Star.Wu
 * @date 2019/05/07
 */
@Data
public class Employee {
    private Integer id;

    private String empLoginname;

    private String empName;

    private String empPassword;

    private String empSalt;

    private Integer empSex;

    private String empPhone;

    private String empEmail;

    private Integer status;

    private Date empLastTime;

    private Date cratetime;

    private Integer isDelete;

    private Integer isAdmin;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmpLoginname(String empLoginname) {
        this.empLoginname = empLoginname;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public void setEmpSalt(String empSalt) {
        this.empSalt = empSalt;
    }

    public void setEmpSex(Integer empSex) {
        this.empSex = empSex;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setEmpLastTime(Date empLastTime) {
        this.empLastTime = empLastTime;
    }

    public void setCratetime(Date cratetime) {
        this.cratetime = cratetime;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public String getEmpLoginname() {
        return empLoginname;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public String getEmpSalt() {
        return empSalt;
    }

    public Integer getEmpSex() {
        return empSex;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public Integer getStatus() {
        return status;
    }

    public Date getEmpLastTime() {
        return empLastTime;
    }

    public Date getCratetime() {
        return cratetime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }
}