package com.wxc.dangxia.service.build;

import com.wxc.dangxia.commons.ResultMsg;

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
    ResultMsg getLandlordInfoByCondition(Map<String,Object> map) throws Exception;

    /**
     * 获得房东列表
     * @param
     * @return
     */
    List<Map<String, Object>> getLandlordList();

    /**
     * 根据条件获得房东数量
     * @param map
     * @return
     */
    Integer getCountByCondition(Map<String, Object> map) throws Exception;

    /**
     * 添加房东
     * @param map
     * @return
     * @throws Exception
     */
    Integer insertLandlord(Map<String, Object> map) throws Exception;

    /**
     * 根据id删除房东
     * @param map
     * @return
     */
    Integer deleteLandlordById(Map<String, Object> map) throws Exception;

    /**
     * 根据条件获得单个房东信息
     * @param map
     * @return
     */
    Map<String, Object> getLandlordByLandlordId(Map<String, Object> map) throws Exception;

    /***
     * 根据条件修改房东信息
     * @param map
     * @return
     */
    Integer updateLandlordByCondition(Map<String, Object> map) throws Exception;
}
