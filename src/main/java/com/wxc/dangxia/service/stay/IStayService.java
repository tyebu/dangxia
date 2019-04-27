package com.wxc.dangxia.service.stay;

import com.wxc.dangxia.commons.ResultMsg;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/26 13:28
 * @description:
 **/
public interface IStayService {
    /**
     * 录入信息
     * @param map
     * @return
     */
    Integer insertStayInfo(Map<String, Object> map) throws Exception;

    /**
     * 获得入住记录
     * @param map
     * @return
     */
    ResultMsg getStayRecordByCondition(Map<String, Object> map);
}
