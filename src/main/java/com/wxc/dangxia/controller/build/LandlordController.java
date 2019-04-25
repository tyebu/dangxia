package com.wxc.dangxia.controller.build;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.service.build.ILandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/24 10:08
 * @description:
 **/
@Controller
@RequestMapping("/landlord")
public class LandlordController {
    @Autowired
    private ILandlordService landlordService;

    @RequestMapping("/toLandlord")
    public String toLandlord() {
        return "build/landlord";
    }
    @RequestMapping(value = "/getLandlordList", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getLandlordList() {
        try {
            List<Map<String, Object>> landlordList = landlordService.getLandlordList();
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.SUCCESS, landlordList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }
    @RequestMapping(value = "/getLandlordByCondition", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getLandlordByCondition(@RequestParam Map<String, Object> map) {
        try {
            List<Map<String, Object>> lanldlordList = landlordService.getLandlordInfoByCondition(map);
            return new ResultMsg(StatusCode.LAYUISUCCESS,StatusMessage.SUCCESS,lanldlordList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.ERROR);
        }
    }
}
