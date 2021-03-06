package com.wxc.dangxia.controller.rent;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.service.rent.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/29 17:16
 * @description:
 **/
@Controller
@RequestMapping("/rent")
public class RentController {
    @Autowired
    IRentService rentService;

    @RequestMapping("/toRentRecordList")
    public String toRentRecordList(){
        return "rent/rent_record";
    }
    @RequestMapping("/toPayrentOffline")
    public String toPayrentOffline() {
        return "rent/payrent_offline";
    }
    @RequestMapping("/toRentingList")
    public String toRentingList() {
        return "rent/rentingList";
    }
    /***
     * 获得交租记录
     * @return
     */
    @RequestMapping(value = "/getRentRecordByCondition", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getRentRecordByCondition(@RequestParam Map<String, Object> map) {
        try {
            return rentService.getRentRecordByCondition(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.ERROR);
        }
    }
    @RequestMapping(value = "/getRentUserInfoByCondition", method = RequestMethod.POST)
    @ResponseBody
     public ResultMsg getRentUserInfoByCondition(@RequestParam Map<String, Object> map) {
        try {
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.SUCCESS, rentService.getRentUserInfoByCondition(map));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    /***
     * 获得待交租人员列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/getToPayRentUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getToPayRentUser(@RequestParam Map<String, Object> map) {
        try {
            return rentService.getToPayRentUser(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    /***
     * 缴纳租金
     * @param map
     * @return
     */
    @RequestMapping(value = "/payRent", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg payRent(@RequestParam Map<String, Object> map) {
        try {
            ResultMsg rm = rentService.payRent(map);
            return rm;
        } catch (Exception e) {

            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

}
