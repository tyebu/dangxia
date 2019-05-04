package com.wxc.dangxia.dao.leave;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName ILeaveDao
 * @Author Star.Wu
 * @Date 2019/5/4 16:46
 */
@Mapper
@Component
public interface ILeaveDao {
    /**
     * 根据证件号获得要离宿用户的信息
     * @param map
     * @return
     * @throws Exception
     */
    Map<String, Object> getLeaveUserInfoByUserCard(Map<String, Object> map) throws  Exception;
}
