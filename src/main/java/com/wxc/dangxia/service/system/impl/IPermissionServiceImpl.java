package com.wxc.dangxia.service.system.impl;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.service.system.IPermissionService;
import org.apache.shiro.authz.Permission;

/**
 * @auther: Star.Wu
 * @date: 2019/5/7 17:33
 * @description:
 **/
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
}
