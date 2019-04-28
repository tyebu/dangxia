package com.wxc.dangxia.controller.stay;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.controller.base.BaseController;
import com.wxc.dangxia.service.stay.IStayService;
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
 * @date: 2019/4/26 12:03
 * @description:入住管理
 **/
@Controller
@RequestMapping("/stay")
public class StayController extends BaseController {
    @Autowired
    private IStayService stayService;
    /**
     * 跳转录入信息页面
     * @return
     */
    @RequestMapping("/toStayAdd")
    public String toStayAdd() {
       return "stay/stay_add";
    }

    @RequestMapping("/toStayRecord")
    public String toStayRecord() {
        return "stay/stay_record";
    }
    /**
     * 新增租客
     * @param map
     * @return
     */
    @RequestMapping(value = "/insertStayInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg insertStayInfo(@RequestParam Map<String, Object> map) {
        try {
            Integer integer = stayService.insertStayInfo(map);
            return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.ADDSUCCESS);
        } catch (CommonException e) {
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    /**
     * 获得住房记录表
     * @return
     */
    @RequestMapping(value = "/getStayRecordByCondition", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getStayRecordByCondition(@RequestParam Map<String, Object> map) {

        return stayService.getStayRecordByCondition(map);
    }
}
