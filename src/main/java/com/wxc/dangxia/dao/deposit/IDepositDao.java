package com.wxc.dangxia.dao.deposit;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName IDepositDao
 * @Author Star.Wu
 * @Date 2019/4/27 11:35
 */
@Mapper
@Component
public interface IDepositDao {
    Integer insertUserDeposit(Map<String, Object> map) throws Exception;
}
