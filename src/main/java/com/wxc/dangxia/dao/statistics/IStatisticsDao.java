package com.wxc.dangxia.dao.statistics;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/5/17 11:39
 * @description:
 **/
@Mapper
@Component
public interface IStatisticsDao {
    List<Map<String, Object>> getStayStatistics(Map<String, Object> map);
    List<Integer> getYear();
}
