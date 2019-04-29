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
}
