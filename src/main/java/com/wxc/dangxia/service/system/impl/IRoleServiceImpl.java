package com.wxc.dangxia.service.system.impl;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.dao.system.IRoleDao;
import com.wxc.dangxia.service.system.IRoleService;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @auther: Star.Wu
 * @date: 2019/05/07 17:37
 * @description:
 **/
@Service
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
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
    public Set<String> getRolesByEmpLoginName(String empLoginame) {
        List<Map<String, Object>> roles = roleDao.getRolesByempLoginname(empLoginame);
        //用来存储员工的角色
        HashSet<String> rolesSet = new HashSet<>();
        for (Map<String, Object> role : roles) {
            rolesSet.add(String.valueOf(role.get("roleName")));
        }
        return rolesSet;
    }
}
