package com.wxc.dangxia.controller.leave;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: Star.Wu
 * @date: 2019/4/26 12:04
 * @description:退宿管理
 **/
@Controller
@RequestMapping("/leave")
public class LeaveController {
    public String toLeave() {
        return "leave/leave";
    }
}
