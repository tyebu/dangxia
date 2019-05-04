package com.wxc.dangxia.service.leave;

import com.wxc.dangxia.commons.ResultMsg;

import java.util.Map;

/**
 * @ClassName ILeaveService
 * @Author Star.Wu
 * @Date 2019/5/4 16:49
 */
public interface ILeaveService {
    /**
     * 根据身份信息获得用户离宿信息
     * @param map
     * @return
     */
    Map<String,Object> getLeaveUserInfoByUserCard(Map<String, Object> map) throws Exception;

    /**
     * 租客退宿
     * @param map
     * @return
     */
    ResultMsg userLeave(Map<String, Object> map) throws Exception;
}
