package com.wxc.dangxia.service.system.impl;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.dao.system.IEmployeeDao;
import com.wxc.dangxia.entity.Employee;
import com.wxc.dangxia.service.system.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/05/07 17:21
 * @description:
 **/
@Service
public class IEmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeDao employeeDao;
    @Override
    public ResultMsg getEmployeeAll(Map<String, Object> query) {
        return null;
    }

    @Override
    public ResultMsg isExistLoginName(Employee emp) {
        return null;
    }

    @Override
    public ResultMsg addEmployee(Employee emp, Integer[] roles) {
        return null;
    }

    @Override
    public ResultMsg updateEmployeeIsDelete(Integer[] ids, int isDelete) {
        return null;
    }

    @Override
    public ResultMsg deleteEmployeeById(Integer[] ids) {
        return null;
    }

    @Override
    public ResultMsg updateEmployeeStatus(Integer id, Integer status) {
        return null;
    }

    @Override
    public ResultMsg getHaveRole(Integer id) {
        return null;
    }

    @Override
    public ResultMsg updateEmployee(Employee emp, Integer[] roles) {
        return null;
    }

    @Override
    public Employee getEmployeeByName(String userName) {
        return employeeDao.getEmployeeByName(userName);
    }
}
