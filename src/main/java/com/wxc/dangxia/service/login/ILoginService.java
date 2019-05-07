package com.wxc.dangxia.service.login;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.entity.Employee;

import java.util.Set;

/**
 * @auther: Star.Wu
 * @date: 2019/5/7 10:27
 * @description:
 **/
public interface ILoginService {
    Set<String> getRolesByUserName(String userName);

    Set<String> getPermissionsByUserName(String userName);

    Employee getEmployeeByName(String userName);

    ResultMsg getMenuTree();

    ResultMsg getMenu();

    ResultMsg updateEmployee(Employee emp);

    String getEmployeeName();
}
