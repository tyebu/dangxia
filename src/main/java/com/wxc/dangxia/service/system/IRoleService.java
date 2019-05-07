package com.wxc.dangxia.service.system;

import com.wxc.dangxia.commons.ResultMsg;
import org.apache.catalina.Role;

import java.util.Map;
import java.util.Set;

/**
 * @auther: Star.Wu
 * @date: 2019/5/7 17:35
 * @description:
 **/
public interface IRoleService {
    ResultMsg getRoleAll(Map<String, Object> query);

    ResultMsg deleteRoleById(Integer id);

    ResultMsg updateRoleStatus(Integer id, Integer status);

    ResultMsg addRole(Role role, Integer[] ids);

    ResultMsg updateRoleById(Role role, Integer[] ids);

    ResultMsg isExistRoleName(Role role);

    Set<String> getRolesByEmpLoginName(String userName);
}
