package com.wxc.dangxia.service.system.impl;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.service.system.IPermissionService;
import org.apache.shiro.authz.Permission;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @auther: Star.Wu
 * @date: 2019/05/07 17:33
 * @description:
 **/
@Service
public class IPermissionServiceImpl implements IPermissionService {
    @Override
    public ResultMsg getPermissionAll(Integer status) {
        return null;
    }

    @Override
    public ResultMsg getPermissionTreeAll(Integer status) {
        return null;
    }

    @Override
    public ResultMsg updatePermissionStatus(Integer id, Integer status) {
        return null;
    }

    @Override
    public ResultMsg addPermission(Permission permi) {
        return null;
    }

    @Override
    public ResultMsg updatePermissionById(Permission permi) {
        return null;
    }

    @Override
    public ResultMsg deletePermissionById(Integer id) {
        return null;
    }

    @Override
    public ResultMsg getRolePermissionById(Integer id) {
        return null;
    }

    /**
     * 根据用户名获取权限
     * @param o
     * @return
     */
    @Override
    public Set<String> getPermissionsByEmpLoginName(Object o) {
        return null;
    }
}
