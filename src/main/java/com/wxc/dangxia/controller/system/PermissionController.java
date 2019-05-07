package com.wxc.dangxia.controller.system;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.service.system.IPermissionService;
import org.apache.shiro.authz.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 权限表前端控制器
 *
 * @author Dadazhao
 * @date 2018/12/18
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionServiceImpl;

    /**
     * 前往权限管理页面
     *
     * @return 权限管理页面
     */
    @RequestMapping("/toPermission")
    public String toPermission() {
        return "/system/permission";
    }

    /**
     * 得到所有的权限
     *
     * @param status 空为所有 0为正常 1为停用
     * @return 权限列表
     */
    @RequestMapping("/getPermissionAll")
    @ResponseBody
    public ResultMsg getPermissionAll(Integer status) {
        return permissionServiceImpl.getPermissionAll(status);
    }


    /**
     * 获得Tree格式的所有权限
     *
     * @param status 空为所有 0为启用的
     * @return tree格式的权限
     */
    @RequestMapping("/getPermissionTreeAll")
    @ResponseBody
    public ResultMsg getPermissionTreeAll(Integer status) {
        return permissionServiceImpl.getPermissionTreeAll(status);
    }

    /**
     * 修改权限状态
     *
     * @param id     权限 id
     * @param status 状态 0 为启用 1 为禁用
     * @return code  0 成功 1 失败
     */
    @RequestMapping("/updatePermissionStatus")
    @ResponseBody
    public ResultMsg updatePermissionStatus(Integer id, Integer status) {
        return permissionServiceImpl.updatePermissionStatus(id, status);
    }

    /**
     * 添加新的权限
     *
     * @param permi permi实体
     * @return code  0 成功 1 失败
     */
    @RequestMapping("/addPermission")
    @ResponseBody
    public ResultMsg addPermission(Permission permi) {
        return permissionServiceImpl.addPermission(permi);
    }

    /**
     * 修改权限
     *
     * @param permi 权限实体
     * @return code  0 成功 1 失败
     */
    @RequestMapping("/updatePermissionById")
    @ResponseBody
    public ResultMsg updatePermissionById(Permission permi) {
        return permissionServiceImpl.updatePermissionById(permi);
    }

    /**
     * 通过ID删除权限
     *
     * @param id 权限id
     * @return code  0 成功 1 失败
     */
    @RequestMapping("/deletePermissionById")
    @ResponseBody
    public ResultMsg deletePermissionById(Integer id) {
        return permissionServiceImpl.deletePermissionById(id);
    }

    /**
     * 通过角色ID获得角色权限
     *
     * @param id 角色id
     * @return 权限列表
     */
    @RequestMapping("/getRolePermissionById")
    @ResponseBody
    public ResultMsg getRolePermissionById(Integer id) {
        return permissionServiceImpl.getRolePermissionById(id);
    }
}
