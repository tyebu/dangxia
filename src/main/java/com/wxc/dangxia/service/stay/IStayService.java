package com.wxc.dangxia.service.stay;

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
     * 获得录入但还未入住的租客信息
     * @param map
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getStayInfoBycondition(Map<String, Object> map) throws Exception;
}
