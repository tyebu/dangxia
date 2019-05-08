package com.wxc.dangxia.service.system;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.entity.Employee;

import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/5/7 17:19
 * @description:
 **/
public interface IEmployeeService {
    ResultMsg getEmployeeAll(Map<String, Object> query);

    ResultMsg isExistLoginName(Employee emp);

    ResultMsg addEmployee(Employee emp, Integer[] roles);

    ResultMsg updateEmployeeIsDelete(Integer[] ids, int isDelete);

    ResultMsg deleteEmployeeById(Integer[] ids);

    ResultMsg updateEmployeeStatus(Integer id, Integer status);

    ResultMsg getHaveRole(Integer id);

    ResultMsg updateEmployee(Employee emp, Integer[] roles);

    Employee getEmployeeByName(String userName);
}
