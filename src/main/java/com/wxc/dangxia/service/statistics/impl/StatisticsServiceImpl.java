package com.wxc.dangxia.service.statistics.impl;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.dao.statistics.IStatisticsDao;
import com.wxc.dangxia.service.statistics.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/5/17 11:38
 * @description:
 **/
@Service
public class StatisticsServiceImpl implements IStatisticsService {
    @Autowired
    private IStatisticsDao statisticsDao;
    @Override
    public ResultMsg getStayStatistics(Map<String, Object> map) {
        List<Map<String, Object>> stayStatistics = statisticsDao.getStayStatistics(map);
        List<Integer> years = statisticsDao.getYear();
        return new ResultMsg(StatusCode.SUCCESS, StatusMessage.SUCCESS, stayStatistics, years);
    }
}
