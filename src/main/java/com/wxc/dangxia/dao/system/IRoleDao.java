package com.wxc.dangxia.dao.system;

import com.wxc.dangxia.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 角色表接口
 *
 * @author Star.Wu
 * @date 2019/05/08
 */
@Mapper
@Component
public interface IRoleDao {
    /**
     * 获得所有的角色
     */
    List<Map<String, Object>> getRoleAll(Map<String, Object> query);

    /**
     * 获得角色的总个数
     * @param query 查询条件
     * @return 角色个数
     */
   int getRoleTotalAll(Map<String, Object> query);

    /**
     * 修改角色状态
     * @param id 角色id
     * @param status 状态 0 启用 1禁用
     * @return 影响的行数
     */
    int updateRoleStatus(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * 删除角色信息
     * @param id 角色id
     * @return 影响行数
     */
    int deleteRoleById(Integer id);

    /**
     * 删除员工角色表关于角色的数据
     * @param id 角色id
     * @return 影响行数
     */
    int deleteEmpRoleByRoleId(Integer id);

    /**
     * 删除角色权限表关于角色的记录
     * @param id 角色id
     * @return 影响行数
     */
    int deleteRolePermissionByRoleId(Integer id);

    /**
     * 添加角色
     * @param role 角色实体
     * @return 影响行数
     */
    int addRole(Role role);

    /**
     * 添加角色权限
     * @param id 角色ID
     * @param ids 权限ID 数组
     * @return 影响行数
     */
    int addRolePermission(@Param("id") Integer id, @Param("ids") Integer[] ids);

    /**
     * 修改角色信息
     * @param role 角色实体
     * @return 影响行数
     */
    int updateRoleById(Role role);

    /**
     * 查询角色名
     * @param role 角色实体
     * @return 角色名相同的总条数
     */
    int isExistRoleName(Role role);

     /**
      * 获得员工拥有的角色
      * @param userName 登录账号
      * @return 角色列表
      */
     List<Map<String, Object>> getRolesByempLoginname(String userName);
}
