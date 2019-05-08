package com.wxc.dangxia.dao.system;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 系统日志记录
 *
 * @author Star.Wu
 * @date 2019/05/08
 */
@Mapper
@Component
public interface IOperationLogDao {
    /**
     * 添加一条日志
     * @param operationLog 日志实体
     * @return 影响行数
     */
    //int addOperationLog(OperationLog operationLog);

    /**
     * 根据条件获得部分数据
     * @param query 查询条件
     * @return 部分日志列表
     */
    List<Map<String,Object>> getOperationLogLimit(Map<String, Object> query);

    /**
     * 查询所有的日志信息
     * @param query 查询条件
     * @return 日志列表
     */
    List<Map<String,Object>> getOperationLogAll(Map<String, Object> query);

    /**
     * 查询所有的日志的总条数
     * @param query  查询条件
     * @return 日志列表总条数
     */
    int getOperationLogTotalAll(Map<String, Object> query);
}
