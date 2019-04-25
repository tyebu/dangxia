package com.wxc.dangxia.service.build;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ILandlordService
 * @Author Star.Wu
 * @Date 2019/4/24 10:00
 */
public interface ILandlordService {
    /**
     * 根据条件获得房东信息
     * @param map
     * @return
     */
    List<Map<String, Object>> getLandlordInfoByCondition(Map<String,Object> map) throws Exception;

    /**
     * 获得房东列表
     * @param
     * @return
     */
    List<Map<String, Object>> getLandlordList();


}
