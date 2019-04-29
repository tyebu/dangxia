package com.wxc.dangxia.dao.rent;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IRentDao
 * @Author Star.Wu
 * @Date 2019/4/27 10:54
 */
@Mapper
@Component
public interface IRentDao {
    /**
     * 向租金记录表插入信息
     * @param map
     * @return
     * @throws Exception
     */
    Integer insertRentRecord(Map<String,Object> map) throws  Exception;

    /**
     * 根据条件获得租金记录表
     * @param map
     * @return
     */
    List<Map<String, Object>> getRentRecordByCondition(Map<String, Object> map) throws  Exception;

    /***
     * 根据条件获得租金记录条数
     * @param map
     * @return
     */
    Integer getRentRecordCountByCondition(Map<String, Object> map);
}
