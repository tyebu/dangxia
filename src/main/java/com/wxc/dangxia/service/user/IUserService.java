package com.wxc.dangxia.service.user;

import com.wxc.dangxia.commons.ResultMsg;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/26 09:46
 * @description:
 **/
public interface IUserService {
    /***
     * 根据条件获得租客信息
     * @param map
     * @return
     */
    ResultMsg getUserInfoByCondition(Map<String, Object> map) throws Exception;

    /**
     * 根据用户Id删除用户
     * @param userId
     * @return
     */
    Integer deleteUserByUserId(Integer userId);
}
