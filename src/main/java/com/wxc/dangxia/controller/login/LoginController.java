package com.wxc.dangxia.controller.login;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.entity.Employee;
import com.wxc.dangxia.service.login.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 登录控制器
 *
 * @author Dadazhao
 * @date 2018/12/21
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    /**
     * 注入登录业务
     */
    @Autowired
    private ILoginService loginService;


    /**
     * 前往登录页
     * @return 登录页
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login/login";
    }

    @RequestMapping("/toError")
    public String toError() {
        return "/error/error";
    }
    /**
     * 前往主页
     * @return 主页
     */
    @RequestMapping("/toIndex")
    public String toIndex(Model m){
        //树形结构的菜单
        ResultMsg menu = loginService.getMenuTree();
        //员工信息
        String username = String.valueOf(SecurityUtils.getSubject().getPrincipal());
        Employee employee = loginService.getEmployeeByName(username);
        //员工名称
        //String empName = loginService.getEmployeeName();
        m.addAttribute("employee",employee);
        m.addAttribute("menus",menu.getData());
        return "/login/index";
    }

    /**
     * 登出
     * @return 退出登录
     */
    @RequestMapping("/toLogout")
    // @SysLog(operateType= SysLog.Type.LOGOUT,desc = "登出系统")
    public String toLogout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/login/login";
    }

    /**
     * 判断是否登录成功
     * @return code 0 为成功 1 为失败
     */
    @RequestMapping("/isLogin")
    @ResponseBody
    // @SysLog(operateType= SysLog.Type.LOGIN,desc = "登录系统")
    public ResultMsg isLogin(Employee employee){
        //获得主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(employee.getEmpLoginname(),employee.getEmpPassword());
        try {
            //身份认证
            subject.login(token);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.LOGIN_SUCCESS);
        }catch (UnknownAccountException e){
            return new ResultMsg(StatusCode.ERROR, StatusMessage.LOGIN_UNDEFINED);
        }catch (DisabledAccountException e){
            return new ResultMsg(StatusCode.ERROR, StatusMessage.LOGIN_UNUSED);
        }catch (IncorrectCredentialsException e){
            return new ResultMsg(StatusCode.ERROR, StatusMessage.LOGIN_ERROR);
        }

    }

    /**
     * 获得菜单
     * @return 所有菜单
     */
    @RequestMapping("/getMenu")
    @ResponseBody
    public ResultMsg getMenu(){
        return loginService.getMenu();
    }

    /**
     * 修改员工的信息
     * @param emp
     * @return
     */
    @RequestMapping("/updateEmployee")
    @ResponseBody
    public ResultMsg updateEmployee(Employee emp){
        return loginService.updateEmployee(emp);
    }

    /**
     * 获得当前用户姓名
     * @return 用户名
     */
    @RequestMapping("/getEmployeeName")
    @ResponseBody
    public String getEmployeeName(){
        return loginService.getEmployeeName();
    }
}
