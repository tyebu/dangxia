package com.wxc.dangxia.controller.user;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/25 17:15
 * @description:
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/toUserInfo")
    public String toUserInfo() {
        return "user/user_info";
    }

    /***
     * 根据条件获得租客信息
     * @return
     */
    @RequestMapping(value = "/getUserInfoByCondition", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getUserInfoByCondition(@RequestParam Map<String, Object> map) {
        return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS);
    }
}
