package com.wxc.dangxia.service.build;

import com.wxc.dangxia.commons.ResultMsg;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IRoomService
 * @Author Star.Wu
 * @Date 2019/4/21 20:40
 */
public interface IRoomService {
    /**
     * 根据条件获得分页的房间信息
     * @param data
     * @return
     */
    ResultMsg getRoomInfoByCondition(Map<String,Object> data) throws Exception;

    /**
     * 添加房间信息
     * @param data
     * @return
     */
    Integer insertRoomInfo(Map<String, Object> data) throws Exception;

    /***
     * 获的房间类型
     * @return
     */
    List<Map<String, Object>> getRoomType(Map<String, Object> map) throws Exception;

    /**
     * 根据条件获得房间列表
     * @param map
     * @return
     * @throws Exception
     */
    ResultMsg getRoomListByCondition(Map<String, Object> map) throws Exception;
}
