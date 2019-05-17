package com.wxc.dangxia.controller.statistics;

import com.wxc.dangxia.commons.ResultMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: Star.Wu
 * @date: 2019/5/17 10:28
 * @description:
 **/
@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @RequestMapping("/toStayStatistics")
    public String toLiveLine() {
        return "statistics/stay_statistics";
    }

    @RequestMapping(value = "getStayStatistics", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getStayStatistics() {

        return new ResultMsg();
    }
}
