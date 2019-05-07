package com.wxc.dangxia.controller.system;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.service.system.IRoleService;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 角色前端控制器
 *
 * @author Dadazhao
 * @date 2018/12/17
 */
@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private IRoleService roleServiceImpl;

    /**
     * 前往角色页面
     *
     * @return 角色页面
     */
    @RequestMapping("/toRole")
    public String toRole() {
        return "/system/role";
    }

    /**
     * 获得所有的角色
     *
     * @param query 查询条件
     * @return 角色列表
     */
    @RequestMapping("/getRoleAll")
    @ResponseBody
    public ResultMsg getRoleAll(@RequestParam Map<String, Object> query) {
        return roleServiceImpl.getRoleAll(query);
    }

    /**
     * 通过ID删除角色
     *
     * @param id 角色id
     * @return code 0 成功 1 失败
     */
    @RequestMapping("/deleteRoleById")
    @ResponseBody
    public ResultMsg deleteRoleById(Integer id) {
        return roleServiceImpl.deleteRoleById(id);
    }

    /**
     * 修改角色状态
     *
     * @param id     角色id
     * @param status 状态 0 正常 1 禁用
     * @return code 0 成功 1 失败
     */
    @RequestMapping("/updateRoleStatus")
    @ResponseBody
    public ResultMsg updateRoleStatus(Integer id, Integer status) {
        return roleServiceImpl.updateRoleStatus(id, status);
    }

    /**
     * 添加新角色
     *
     * @param role 角色实体
     * @param ids  权限id 数组
     * @return code 0 成功 1 失败
     */
    @RequestMapping("/addRole")
    @ResponseBody
    public ResultMsg addRole(Role role, @RequestParam(value = "ids") Integer[] ids) {
        return roleServiceImpl.addRole(role, ids);
    }

    /**
     * 修改角色的权限和信息
     *
     * @param role 角色实体
     * @param ids  权限id数组
     * @return code 0 成功 1 失败
     */
    @RequestMapping("updateRoleById")
    @ResponseBody
    public ResultMsg updateRoleById(Role role, @RequestParam(value = "ids") Integer[] ids) {
        return roleServiceImpl.updateRoleById(role, ids);
    }

    /**
     * 查看角色名是否存在
     *
     * @param role 角色实体
     * @return code 0 存在 1 不存在
     */
    @RequestMapping("/isExistRoleName")
    @ResponseBody
    public ResultMsg isExistRoleName(Role role) {
        return roleServiceImpl.isExistRoleName(role);
    }
}
