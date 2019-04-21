package com.wxc.dangxia.service.build;

import com.wxc.dangxia.entity.build.Building;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BuildingsService
 * @Author zfy
 * @Date 2019/4/7 15:52
 * 单元信息业务
 */
public interface IBuildingsService {
    /***
     * 根据条件获得分页数据
     * @param data
     * @return
     */
    List<Building> getBuildingsByCondition(Map<String, Object> data) throws Exception;

    /***
     * 添加楼栋信息
     * @param data
     * @return
     */
    Integer insertBuilding(Map<String, Object> data) throws Exception;
}
