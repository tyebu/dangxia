package com.wxc.dangxia.service.login.impl;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.entity.Employee;
import com.wxc.dangxia.service.login.ILoginService;
import com.wxc.dangxia.service.system.IEmployeeService;
import com.wxc.dangxia.service.system.IPermissionService;
import com.wxc.dangxia.service.system.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @auther: Star.Wu
 * @date: 2019/5/7 10:28
 * @description:
 **/
@Service
public class LoginServiceImpl implements ILoginService {
    /**
     * 注入员工业务层
     */
    @Autowired
    private IEmployeeService employeeService;
    /**
     * 注入权限业务层
     */
    @Autowired
    private IPermissionService permissionService;
    /**
     * 注入角色业务层
     */
    @Autowired
    private IRoleService roleService;
    @Override
    public Set<String> getRolesByUserName(String userName) {
        return roleService.getRolesByEmpLoginName(userName);
    }

    @Override
    public Set<String> getPermissionsByUserName(String userName) {
        return null;
    }

    @Override
    public Employee getEmployeeByName(String userName) {
        return null;
    }

    @Override
    public ResultMsg getMenuTree() {
        return null;
    }

    @Override
    public ResultMsg getMenu() {
        return null;
    }

    @Override
    public ResultMsg updateEmployee(Employee emp) {
        return null;
    }

    @Override
    public String getEmployeeName() {
        return null;
    }
}
