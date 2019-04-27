package com.wxc.dangxia.dao.rent;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName IRentDao
 * @Author Star.Wu
 * @Date 2019/4/27 10:54
 */
@Mapper
@Component
public interface IRentDao {
    /**
     * 向租金记录表插入信息
     * @param map
     * @return
     * @throws Exception
     */
    Integer insertRentRecord(Map<String,Object> map) throws  Exception;
}
