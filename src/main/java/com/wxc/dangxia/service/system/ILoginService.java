package com.wxc.dangxia.service.system;

import com.wxc.dangxia.entity.Employee;

/**
 * @auther: Star.Wu
 * @date: 2019/5/13 17:16
 * @description:
 **/
public interface ILoginService {
    Employee getEmployeeByUserName(String userName);
}
