package com.wxc.dangxia.controller.build;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.controller.base.BaseController;
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
public class LandlordController extends BaseController {
    @Autowired
    private ILandlordService landlordService;
    @RequestMapping("/toLandlord")
    public String toLandlord() {
        return "build/landlord";
    }
    @RequestMapping("/toLandlordOper")
    public String toLandlordOper() {
        return "build/landlord_oper";
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
           return landlordService.getLandlordInfoByCondition(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.ERROR);
        }
    }

    /**
     * 添加房东
     * @param map
     * @return
     */
    @RequestMapping(value = "/insertLandlord", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg insertLandlord(@RequestParam Map<String, Object> map) {
        try {
            landlordService.insertLandlord(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.ADDSUCCESS);
        } catch(CommonException e) {
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    /**
     * 根据id删除房东
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleteLandlordById", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg deleteLandlordById(@RequestParam Map<String,Object> map) {
        try {
            landlordService.deleteLandlordById(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.DELETESUCCESS);
        } catch(CommonException e){
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    @RequestMapping(value = "/getLandlordByLandlordId", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getLandlordByLandlordId(@RequestParam Map<String, Object> map) {
        try {
            Map<String, Object> landlordByLandlordId = landlordService.getLandlordByLandlordId(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.SUCCESS, landlordByLandlordId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    @RequestMapping(value = "/updateLandlordByCondition", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg updateLandlordByCondition(@RequestParam Map<String, Object> map) {
        try {
            Integer rows = landlordService.updateLandlordByCondition(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.UPDATESUCCESS);
        } catch (CommonException e) {
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }
}
