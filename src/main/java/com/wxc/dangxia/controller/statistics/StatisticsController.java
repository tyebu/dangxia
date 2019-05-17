package com.wxc.dangxia.controller.statistics;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.service.statistics.IStatisticsService;
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
 * @date: 2019/5/17 10:28
 * @description:
 **/
@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private IStatisticsService statisticsService;
    @RequestMapping("/toStayStatistics")
    public String toLiveLine() {
        return "statistics/stay_statistics";
    }

    /**
     * 获得入住统计数据
     * @param map
     * @return
     */
    @RequestMapping(value = "getStayStatistics", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg getStayStatistics(@RequestParam Map<String, Object> map) {
        return statisticsService.getStayStatistics(map);
    }
}
