package com.wxc.dangxia.dao.build;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ILandlordDao
 * @Author Star.Wu
 * @Date 2019/4/24 9:58
 */
@Mapper
@Component
public interface ILandlordDao {
    /***
     * 根据条件获得房东信息
     * @param map
     * @return
     */
    List<Map<String, Object>> getLandlordInfoByCondition(Map<String,Object> map) throws Exception;

    /**
     * 获得房东列表
     * @return
     */
    List<Map<String, Object>> getLandlordList();
}
