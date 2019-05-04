package com.wxc.dangxia.controller.leave;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.service.leave.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/26 12:04
 * @description:退宿管理
 **/
@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    private ILeaveService leaveService;
    @RequestMapping("/toLeave")
    public String toLeave() {
        return "leave/leave";
    }

    @RequestMapping(value = "/getLeaveUserInfoByUserCard", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getLeaveUserInfoByUserCard(@RequestParam Map<String, Object> map) {
        try {
            Map<String, Object> leaveUserInfo = leaveService.getLeaveUserInfoByUserCard(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.SUCCESS, leaveUserInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }
    @RequestMapping(value = "/userLeave", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg userLeave(@RequestParam Map<String, Object> map) {
        try {
            return leaveService.userLeave(map);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }
}
