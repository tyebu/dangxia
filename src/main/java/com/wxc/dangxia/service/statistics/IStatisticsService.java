package com.wxc.dangxia.service.statistics;

import com.wxc.dangxia.commons.ResultMsg;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/5/17 11:38
 * @description:
 **/
public interface IStatisticsService {
    /**
     * 获得入住人数统计数据
     * @param map
     * @return
     */
    ResultMsg getStayStatistics(Map<String, Object> map);
}
