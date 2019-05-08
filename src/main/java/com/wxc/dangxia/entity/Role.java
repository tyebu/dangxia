package com.wxc.dangxia.entity;

import lombok.Data;

import java.util.Date;
/**
 * 角色表实体
 *
 * @author Star.Wu
 * @date 2019/05/09
 */
@Data
public class Role {
    private Integer id;

    private String roleName;

    private String roleDescription;

    private Date createtime;

    private Date revamptime;

    private Integer status;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setRevamptime(Date revamptime) {
        this.revamptime = revamptime;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public Date getRevamptime() {
        return revamptime;
    }

    public Integer getStatus() {
        return status;
    }
}