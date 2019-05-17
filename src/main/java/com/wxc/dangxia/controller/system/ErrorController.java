package com.wxc.dangxia.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: Star.Wu
 * @date: 2019/5/13 16:50
 * @description:
 **/
@Controller
@RequestMapping("/error")
public class ErrorController {
    @RequestMapping("/toError")
    public String toError() {
        return "error/error";
    }
}
