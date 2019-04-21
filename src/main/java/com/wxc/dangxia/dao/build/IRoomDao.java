package com.wxc.dangxia.dao.build;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IRoomDao
 * @Author Star.Wu
 * @Date 2019/4/21 16:34
 */
@Mapper
@Component
public interface IRoomDao {
    /**
     * 获得房间信息
     * @param map
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> getRoomInfoByCondition(Map<String,Object> map) throws Exception;

    /***
     * 根据条件获得数据条数
     * @return
     * @throws Exception
     */
    Integer getCountByCondition(Map<String,Object> map) throws Exception;
}
