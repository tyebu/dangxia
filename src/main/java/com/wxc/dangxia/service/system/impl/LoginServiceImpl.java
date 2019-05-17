package com.wxc.dangxia.service.system.impl;

import com.wxc.dangxia.dao.system.IEmployeeDao;
import com.wxc.dangxia.entity.Employee;
import com.wxc.dangxia.service.system.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: Star.Wu
 * @date: 2019/5/13 17:17
 * @description:
 **/
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private IEmployeeDao employeeDao;
    @Override
    public Employee getEmployeeByUserName(String userName) {
        Employee employee = employeeDao.getEmployeeByName(userName);
        return employee;
    }
}
