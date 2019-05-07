package com.wxc.dangxia.controller.system;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.entity.Employee;
import com.wxc.dangxia.service.system.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 员工表前端控制器
 *
 * @author Star.Wu
 * @date 2019/05/07
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeServiceImpl;

    /**
     * 前往Employee页面
     *
     * @return 跳转页面
     */
    @RequestMapping("/toEmployee")
    public String toEmployee() {
        return "/system/employee";
    }

    /**
     * 前往添加员工页面(已弃用)
     */
    @RequestMapping("/toAddEmployee")
    public String toAddEmployee() {
        return "/system/employeeadd";
    }

    /**
     * 得到所有员工
     *
     * @return 员工列表
     */
    @RequestMapping("/getEmployeeAll")
    @ResponseBody
    public ResultMsg getEmployeeAll(@RequestParam Map<String, Object> query) {
        return employeeServiceImpl.getEmployeeAll(query);
    }

    /**
     * 查看员工名是否存在
     *
     * @param emp 员工bean
     * @return code 存在 0 不存在 1
     */
    @RequestMapping("/isExistLoginName")
    @ResponseBody
    public ResultMsg isExistLoginName(Employee emp) {
        return employeeServiceImpl.isExistLoginName(emp);
    }

    /**
     * 添加员工
     *
     * @param emp   员工实体
     * @param roles 角色数组
     * @return code 成功 0  失败 1
     */
    @RequestMapping("/addEmployee")
    @ResponseBody
    public ResultMsg addEmployee(Employee emp, @RequestParam Integer[] roles) {
        return employeeServiceImpl.addEmployee(emp, roles);
    }

    /**
     * 员工假删除
     *
     * @param ids id集合
     * @return code 删除成功 0 失败 1
     */
    @RequestMapping("/updateEmployeeIsDelete")
    @ResponseBody
    public ResultMsg updateEmployeeIsDelete(@RequestParam(value = "ids[]") Integer[] ids, int isDelete) {
        return employeeServiceImpl.updateEmployeeIsDelete(ids, isDelete);
    }

    /**
     * 通过id删除员工
     *
     * @param ids id集合
     * @return code 删除成功 0 失败 1
     */
    @RequestMapping("/deleteEmployeeById")
    @ResponseBody
    public ResultMsg deleteEmployeeById(@RequestParam(value = "ids[]") Integer[] ids) {
        return employeeServiceImpl.deleteEmployeeById(ids);
    }

    /**
     * 更新员工账号状态
     *
     * @return code 修改成功 0 失败 1
     */
    @RequestMapping("/updateEmployeeStatus")
    @ResponseBody
    public ResultMsg updateEmployeeStatus(Integer id, Integer status) {
        return employeeServiceImpl.updateEmployeeStatus(id, status);
    }

    /**
     * 查询账号拥有的角色
     *
     * @param id 员工编号
     * @return 拥有的角色
     */
    @RequestMapping("/getHaveRole")
    @ResponseBody
    public ResultMsg getHaveRole(Integer id) {
        return employeeServiceImpl.getHaveRole(id);
    }

    /**
     * 修改员工信息&拥有角色信息
     *
     * @return code 成功 0 失败 1
     */
    @RequestMapping("/updateEmployee")
    @ResponseBody
    public ResultMsg updateEmployee(Employee emp, @RequestParam Integer[] roles) {
        return employeeServiceImpl.updateEmployee(emp, roles);
    }

}
