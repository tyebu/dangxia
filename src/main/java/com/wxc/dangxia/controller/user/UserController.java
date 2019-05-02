package com.wxc.dangxia.controller.user;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private IUserService userService;
    @RequestMapping("/toUserInfo")
    public String toUserInfo() {
        return "user/user_info";
    }
    @RequestMapping("/toUserOper")
    public String toUserOper() {
        return "user/user_oper";
    }
    /***
     * 根据条件获得租客信息
     * @return
     */
    @RequestMapping(value = "/getUserInfoByCondition", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getUserInfoByCondition(@RequestParam Map<String, Object> map) {
        try {
            return userService.getUserInfoByCondition(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS);
        }
    }

    /***
     * 根据userId删除用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleteUserByUserId", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg deleteUserByUserId(@RequestParam Map<String, Object> map) {
        try {
            userService.deleteUserByUserId(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.DELETESUCCESS);
        } catch (CommonException e) {
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    /**
     * 根据用户id获得用户信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/getUserInfoByUserId", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getUserInfoByUserId(@RequestParam Map<String, Object> map) {
        try {
            Map<String, Object> userInfoByUserId = userService.getUserInfoByUserId(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.SUCCESS, userInfoByUserId);
        } catch (CommonException e) {
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    /**
     * 根据条件修改用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg updateUser(@RequestParam Map<String,Object> map) {
        try {
            userService.updateUser(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.UPDATESUCCESS);
        } catch (CommonException e){
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }
}
