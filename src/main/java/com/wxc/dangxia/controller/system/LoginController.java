package com.wxc.dangxia.controller.system;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.entity.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @auther: Star.Wu
 * @date: 2019/5/13 16:23
 * @description:
 **/
@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login/login";
    }
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();//取出当前验证主体
        if(subject != null) {
            subject.logout();
        }
        return "login/toLogin";
    }
    @RequestMapping(value = "/loginEmployee", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg loginEmployee(Employee emp, HttpSession session) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(emp.getEmpLoginName(), emp.getEmpPassword());
            Subject subject = SecurityUtils.getSubject();
            //获取到信息开始验证
            System.out.println("获取到信息开始验证");
            subject.login(token);
            System.out.println("-----------------------");
            System.out.println(subject.getPrincipal());
            Employee emp2 = (Employee) subject.getPrincipal();
            //如果登录成功则把用户信息放入session
            session.setAttribute("emp",emp2);
        } catch(DisabledAccountException e) {
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (UnknownAccountException e){
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }

        return new ResultMsg(StatusCode.SUCCESS, StatusMessage.LOGIN_SUCCESS);
    }

}
