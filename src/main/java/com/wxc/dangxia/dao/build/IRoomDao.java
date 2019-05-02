package com.wxc.dangxia.dao.build;

import com.wxc.dangxia.commons.ResultMsg;
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

    /**
     * 添加房间信息
     * @param data
     * @return
     * @throws Exception
     */
    Integer insertRoomInfo(Map<String, Object> data) throws  Exception;

    /**
     * 获的房间类型
     * @param map
     * @return
     */
    List<Map<String, Object>> getRoomType(Map<String,Object> map) throws Exception;

    /**
     *
     * @param map
     * @return
     */
    Integer insertRoomUser(Map<String, Object> map) throws Exception;

    /**
     * 根据房间id获得房间信息
     * @param roomId
     * @return
     */
    Map<String, Object> getRoomInfoByRoomId(Integer roomId);

    /**
     * 修改房间信息
     * @param map
     * @return
     * @throws Exception
     */
    Integer updateRoomInfo(Map<String, Object> map) throws  Exception;

    /**
     * 获得房间入住人数
     * @param map
     * @return
     */
    Integer getPeopleCountByRoomId(Map<String, Object> map);
}
