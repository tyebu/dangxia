package com.wxc.dangxia.controller.login;

import com.wxc.dangxia.commons.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 欢迎页前端控制器
 *
 * @author Dadazhao
 * @date 2018/12/27
 */
@Controller
@RequestMapping("/welcome")
public class WelcomeController {

  /*  @Autowired
    private IWelcomeService welcomeServiceImpl;*/

    /**
     * 前往欢迎页
     * @return 欢迎页
     */
    @RequestMapping("/toWelcome")
    public String toWelcome(){
        return "/login/welcome";
    }

    /**
     * 获得数量信息
     * @return 各种数量信息
     */
    /*@RequestMapping("/getCountInfo")
    @ResponseBody
    public ResultMsg getCountInfo(){

        return welcomeServiceImpl.getCountInfo();
    }*/

}
