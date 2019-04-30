package com.wxc.dangxia.service.rent;

import com.wxc.dangxia.commons.ResultMsg;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/29 17:18
 * @description:
 **/
public interface IRentService {
    ResultMsg getRentRecordByCondition(Map<String, Object> map) throws Exception;

    /**
     * 根据条件获得用户信息
     * @param map
     * @return
     * @throws Exception
     */
    Map<String, Object> getRentUserInfoByCondition(Map<String, Object> map) throws  Exception;
}
