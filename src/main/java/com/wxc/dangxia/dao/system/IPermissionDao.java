package com.wxc.dangxia.dao.system;

import com.wxc.dangxia.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 权限表接口
 *
 * @author Star.Wu
 * @date 2019/05/08
 */
@Mapper
@Component
public interface IPermissionDao {
    /**
     * 查询所有的权限
     * @param status 空为所有 0为正常 1为停用
     * @return 权限列表
     */
    List<Map<String,Object>> getPermissionAll(@Param("status") Integer status);

    /**
     * 修改权限的状态
     * @param id 权限id
     * @param status 状态 0 启用 1 禁用
     * @return 影响的行数
     */
    int updatePermissionStatus(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * 添加新的权限
     * @param permi 权限实体
     * @return 影响的行数
     */
    int addPermission(Permission permi);

    /**
     * 修改权限
     * @param permi 权限实体
     * @return 影响的行数
     */
    int updatePermissionById(Permission permi);

    /**
     * 查询权限
     * @param id 权限id
     * @param status 状态 0 启用 1 禁用
     * @return  子权限列表
     */
    List<Map<String, Object>> getChildPermissionById(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * 删除权限
     * @param id 权限id
     * @return 影响的行数
     */
    int deletePermissionById(@Param("id") Integer id);

    /**
     * 通过角色id获得拥有的权限id
     * @param id 角色id
     * @return 权限列表
     */
    List<Map<String,Object>> getRolePermissionById(@Param("id") Integer id);

    /**
     * 通过员工id获得所有启用的权限
     * @param id 员工id
     * @return 权限列表
     */
    List<Map<String, Object>> getHavePermissionById(@Param("id") Integer id);

    /**
     * 通过员工姓名获得员工拥有的权限
     * @param empLoginName 登录账号
     * @return 权限列表
     */
    List<Map<String, Object>> getHavePermissionByEmpLoginName(String empLoginName);

    /**
     * 删除权限角色表有关权限Id的所有有关数据
     * @param id 权限id
     * @return 影响行数
     */
    int deleteRolePermissionByPermissionId(@Param("id") Integer id);
}
