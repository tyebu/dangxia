package com.wxc.dangxia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Author Star.Wu
 * @Date 2019/4/6 22:10
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }
    @RequestMapping("/welcome")
    public String toWelcome() {
        return "welcome";
    }
}
