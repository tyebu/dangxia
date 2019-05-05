package com.wxc.dangxia.dao.leave;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
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

    /**
     * 向离宿表插入数据
     * @param map
     * @return
     * @throws Exception
     */
    Integer insertLeaveRecord(Map<String, Object> map) throws Exception;

    /**
     * 获得入住记录
     * @param map
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> getLeaveRecordByCondition(Map<String, Object> map) throws Exception;

    /**
     * 根据条件获得入住记录条数
     * @param map
     * @return
     * @throws Exception
     */
    Integer getLeaveCountByCondition(Map<String, Object> map) throws Exception;
}
