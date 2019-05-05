package com.wxc.dangxia.dao.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/26 09:48
 * @description:
 **/
@Mapper
@Component
public interface IUserDao {
    /**
     * 根据条件获得用户信息
     * @param map
     * @return
     */
    List<Map<String, Object>> getUserInfoByCondition(Map<String, Object> map) throws Exception;

    /***
     * 根据条件获得用户数量
     * @param map
     * @return
     */
    Integer getCountByCondition(Map<String, Object> map);

    /**
     * 添加用户信息
     * @param map
     * @return
     * @throws Exception
     */
    Integer insertUserInfo(Map<String,Object> map) throws  Exception;

    /**
     * 获得录入的租客信息
     * @param map
     * @return
     */
    List<Map<String, Object>>getStayInfoByCondition(Map<String,Object> map);

    /**
     * 获得要交租的租客的信息
     * @param map
     * @return
     */
    Map<String, Object> getRentUserInfoByCondition(Map<String,Object> map);

    /**
     * 修改用户信息
     * @param map
     * @return
     */
    Integer updateUserByCondition(Map<String, Object> map) throws  Exception;

    /**
     * 根据用户id获得用户状态
     * @param userId
     * @return
     * @throws Exception
     */
    Integer getUserStatusByUserId(Integer userId) throws  Exception;

    /***
     * 根据条件获得待交租房客
     * @param map
     * @return
     */
    List<Map<String, Object>> getToPayRentUser(Map<String, Object> map) throws Exception;

    /**
     * 获得待交租房客总条数
     * @param map
     * @return
     * @throws Exception
     */
    Integer getToPayRentCount(Map<String, Object> map) throws Exception;
}
