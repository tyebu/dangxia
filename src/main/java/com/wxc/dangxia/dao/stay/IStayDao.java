package com.wxc.dangxia.dao.stay;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/26 12:58
 * @description:入住数据
 **/
@Mapper
@Component
public interface IStayDao {
    /**
     * 插入入住记录
     * @param map
     * @return
     */
    Integer insertStayRecord(Map<String,Object> map) throws  Exception;

    /**
     * 获得入住记录
     * @param map
     * @return
     */
    List<Map<String, Object>> getStayRecordByCondition(Map<String,Object> map);

    /**
     * 根据条件获得数量
     * @param map
     * @return
     */
    Integer getStayRecordCountByCondition(Map<String, Object> map);
}
