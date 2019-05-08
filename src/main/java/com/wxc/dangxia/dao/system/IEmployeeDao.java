package com.wxc.dangxia.dao.system;

import com.wxc.dangxia.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 员工表接口
 *
 * @author Dadazhao
 * @date 2018/12/14
 */
@Mapper
@Component
public interface IEmployeeDao {
    /**
     * 得到所有的员工(未假删除)
     * @param query 查询条件
     * @return 员工列表
     */
    List<Map<String,Object>> getEmployeeAll(Map<String, Object> query);

    /**
     * 得到所有的员工的条数(未假删除)
     * @param query 查询条件
     * @return 员工的条数
     */
    int getEmployeeTotalAll(Map<String, Object> query);

    /**
     * 修改员工账号状态
     * @param id 员工id
     * @param status 状态 0 正常 1 禁用
     * @return 影响行数
     */
    int updateEmployeeStatus(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * 员工假删除
     * @param id 员工id
     * @param isDelete 删除状态  1为删除 0 为正常
     * @return 影响的行数
     */
    int updateEmployeeIsDelete(@Param("id") Integer[] id, @Param("isDelete") int isDelete);

    /**
     * 添加员工获得主键
     * @param emp 员工实体
     * @return 影响行数  返回主键
     */
    int addEmployee(Employee emp);

    /**
     * 在员工角色表添加
     * @param key 员工id
     * @param roles 角色id 集合
     * @return 影响行数
     */
    int addEmpRoleMapper(@Param("key") String key, @Param("roles") Integer[] roles);

    /**
     * 通过Id获得拥有的角色
     * @param id  员工id
     * @return 角色列表
     */
    List<Map<String,Object>> getHaveRole(Integer id);

    /**
     * 修改员工信息
     * @param emp 员工实体
     * @return 影响行数
     */
    int updateEmployee(Employee emp);

    /**
     * 删除所有有关id的角色映射
     * @param id 员工id
     * @return 影响行数
     */
    int deleteHaveRole(Integer id);

    /**
     * 通过登录名获取用户信息
     * @param username 登录账号
     * @return 用户信息
     */
    Employee getEmployeeByName(String username);

    /**
     * 查寻登录名等于loginName的数据
     * @param emp 员工实体
     * @return 数据条数
     */
    int isExistLoginName(Employee emp);

    /**
     * 通过id删除数据
     * @param id 员工id
     * @return 影响的行数
     */
    int deleteEmployeeById(@Param("id") Integer[] id);

    /**
     * 通过员工id 删除员工角色表的相关数据
     * @param id 员工id
     * @return 受影响的行数
     */
    int deleteEmployeeRoleById(@Param("id") Integer[] id);
}
