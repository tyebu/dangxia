package com.wxc.dangxia.controller.build;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.service.build.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @ClassName RoomController
 * @Author Star.Wu
 * @Date 2019/4/21 16:11
 */
@RequestMapping("/room")
@Controller
public class RoomController {

    @Autowired
    private IRoomService roomService;
    @RequestMapping(value = "/toRoom")
    public String toRoom() {
       return "build/room";
    }
    @RequestMapping(value = "/roomOper")
    public String toRoomOper() {
        return "build/room_oper";
    }
    /**
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/getRoomInfoByCondition", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getRoomInfoByCondition(@RequestParam Map<String,Object> data) {
        try {
            return roomService.getRoomInfoByCondition(data);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.ERROR,null);
        }
    }

    /**
     * 添加房间信息
     * @param data
     * @return
     */
    public ResultMsg insertRoomInfo(@RequestParam Map<String, Object> data) {
        try {
            Integer rows = roomService.insertRoomInfo(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
