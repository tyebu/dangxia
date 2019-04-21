package com.wxc.dangxia.service.area;

import com.wxc.dangxia.entity.build.Area;

import java.util.List;

/**
 * @ClassName AreaService
 * @Author Star.Wu
 * @Date 2019/4/10 21:34
 * 位置管理
 */
public interface AreaService {
    List<Area> getAreaInfo() throws Exception;

    Integer insertArea(Area area) throws Exception;

    /**
     * 根据id删除area信息
     * @param areaId
     * @return
     */
    Integer deleteAreaById(Integer areaId) throws Exception;

    Integer updateAreaByCondition(Area area) throws Exception;

    /**
     * 获得所有区域,
     * @return
     */
    List<String> getAreaName() throws Exception;

    List<String> getNeighbourhoodByAreaName(String areaName) throws Exception;

}
