package com.wxc.dangxia.service.build;

import com.wxc.dangxia.commons.ResultMsg;

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
}
