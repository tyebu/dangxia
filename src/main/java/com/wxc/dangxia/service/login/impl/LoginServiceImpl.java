package com.wxc.dangxia.service.login.impl;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.entity.Employee;
import com.wxc.dangxia.service.login.ILoginService;
import com.wxc.dangxia.service.system.IEmployeeService;
import com.wxc.dangxia.service.system.IPermissionService;
import com.wxc.dangxia.service.system.IRoleService;
import org.apache.shiro.SecurityUtils;
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

    /**
     * 根据用户名获得权限
     * @param userName
     * @return
     */
    @Override
    public Set<String> getPermissionsByUserName(String userName) {
        //获得员工信息
        Employee employee = employeeService.getEmployeeByName(userName);
        //判断是否管理员
        if (1==employee.getIsAdmin()) {
            //所有的权限
            return  permissionService.getPermissionsByEmpLoginName(null);
        }else{
            //拥有的权限
            return  permissionService.getPermissionsByEmpLoginName(userName);
        }
    }

    @Override
    public Employee getEmployeeByName(String userName) {
        return employeeService.getEmployeeByName(userName);
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
        //获得员工信息
        Employee employee = getLoginEmployeeInfo();
        if (employee == null) {
            return null;
        }
        return employee.getEmpName();
    }

    /**
     * 获得当前登录员工的信息
     * @return
     */
    @Override
    public Employee getLoginEmployeeInfo(){
        //从主体获得登录账号
        String loginName = String.valueOf(SecurityUtils.getSubject().getPrincipal());
        //获得员工信息
        Employee employee = employeeService.getEmployeeByName(loginName);
        return  employee;
    }
}
