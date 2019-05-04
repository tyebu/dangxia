package com.wxc.dangxia.controller.build;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.controller.base.BaseController;
import com.wxc.dangxia.service.build.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RoomController
 * @Author Star.Wu
 * @Date 2019/4/21 16:11
 */
@RequestMapping("/room")
@Controller
public class RoomController extends BaseController {

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
    @RequestMapping(value = "/insertRoomInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultMsg insertRoomInfo(@RequestParam Map<String, Object> data) {
        try {
            Integer rows = roomService.insertRoomInfo(data);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.ADDSUCCESS);
        } catch (CommonException e) {
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    @RequestMapping(value = "/getRoomType", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getRoomType(@RequestParam Map<String, Object> map) {
        try {
            List<Map<String, Object>> roomType = roomService.getRoomType(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.SUCCESS, roomType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }
    @RequestMapping(value = "getRoomListByCondition", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getRoomListByCondition(@RequestParam  Map<String,Object> map) {
        try {
            return roomService.getRoomListByCondition(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR,StatusMessage.ERROR);
        }
    }

    /**
     * 根据id删除房间
     * @param map
     * @return
     */
    @RequestMapping(value = "deleteRoomById", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg deleteRoomById(@RequestParam Map<String, Object> map) {
        try {
            Integer rows = roomService.deleteRoomById(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.DELETESUCCESS);
        } catch(CommonException e) {
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    /**
     * 根据roomId获得房间信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/getRoomInfoByRoomId", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getRoomInfoByRoomId(@RequestParam Map<String, Object> map) {
        try {
            Map<String, Object> data = roomService.getRoomInfoByRoomId(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    @RequestMapping(value = "/updateRoomInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg updateRoomInfo(@RequestParam Map<String, Object> map) {
        try {
            Integer rows = roomService.updateRoomInfo(map);
            return new ResultMsg(StatusCode.SUCCESS,StatusMessage.UPDATESUCCESS);
        } catch(CommonException e){
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

}
