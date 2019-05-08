package com.wxc.dangxia.service.system;

import com.wxc.dangxia.commons.ResultMsg;
import org.apache.shiro.authz.Permission;

import java.util.Set;

/**
 * @auther: Star.Wu
 * @date: 2019/5/7 17:32
 * @description:
 **/
public interface IPermissionService {
    ResultMsg getPermissionAll(Integer status);

    ResultMsg getPermissionTreeAll(Integer status);

    ResultMsg updatePermissionStatus(Integer id, Integer status);

    ResultMsg addPermission(Permission permi);

    ResultMsg updatePermissionById(Permission permi);

    ResultMsg deletePermissionById(Integer id);

    ResultMsg getRolePermissionById(Integer id);

    Set<String> getPermissionsByEmpLoginName(Object o);
}
