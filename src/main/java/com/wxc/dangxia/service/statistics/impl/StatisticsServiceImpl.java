package com.wxc.dangxia.service.statistics.impl;

import com.wxc.dangxia.dao.statistics.IStatisticsDao;
import com.wxc.dangxia.service.statistics.IStatisticsService;
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
    private IStatisticsDao statisticsDao;
    public List<Map<String, Object>> getStayStatistics() {
        return statisticsDao.getStayStatistics();
    }
}
