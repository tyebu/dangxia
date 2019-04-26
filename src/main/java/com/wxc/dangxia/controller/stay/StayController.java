package com.wxc.dangxia.controller.stay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: Star.Wu
 * @date: 2019/4/26 12:03
 * @description:入住管理
 **/
@Controller
@RequestMapping("/stay")
public class StayController {
    /**
     * 跳转录入信息页面
     * @return
     */
    @RequestMapping("/toStayAdd")
    public String toStayAdd() {
       return "stay/stay_add";
    }

    /**
     * 跳转到待入住列表页面
     * @return
     */
    public String toStay() {
        return "stay/to_stay";
    }
}
