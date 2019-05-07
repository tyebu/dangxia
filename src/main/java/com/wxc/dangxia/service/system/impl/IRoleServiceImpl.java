package com.wxc.dangxia.service.system.impl;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.service.system.IRoleService;
import org.apache.catalina.Role;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * @auther: Star.Wu
 * @date: 2019/05/07 17:37
 * @description:
 **/
@Service
public class IRoleServiceImpl implements IRoleService {
    @Override
    public ResultMsg getRoleAll(Map<String, Object> query) {
        return null;
    }

    @Override
    public ResultMsg deleteRoleById(Integer id) {
        return null;
    }

    @Override
    public ResultMsg updateRoleStatus(Integer id, Integer status) {
        return null;
    }

    @Override
    public ResultMsg addRole(Role role, Integer[] ids) {
        return null;
    }

    @Override
    public ResultMsg updateRoleById(Role role, Integer[] ids) {
        return null;
    }

    @Override
    public ResultMsg isExistRoleName(Role role) {
        return null;
    }

    @Override
    public Set<String> getRolesByEmpLoginName(String userName) {
        return null;
    }
}
