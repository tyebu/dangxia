package com.wxc.dangxia.dao.area;

import com.wxc.dangxia.entity.build.Area;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName IAreaDao
 * @Author zfy
 * @Date 2019/4/10 21:39
 */
@Mapper
@Component
public interface IAreaDao {
    /**
     * 获得位置信息
     * @return
     */
    List<Area> getAreaInfo() throws  Exception;

    /**
     * 添加位置
     * @param area
     * @return
     */
    Integer insertArea(Area area) throws Exception;

    /**
     * 根据位置获得id
     * @return
     * @throws Exception
     */
    Integer getIdByAreaNameAndNeighbourhood(Area area) throws  Exception;

    /**
     * 根据id删除地区
     * @param areaId
     * @return
     */
    Integer deleteAreaById(Integer areaId) throws Exception;

    /**
     * 根据条件修改数据
     * @param area
     * @return
     */
    Integer updateAreaByCondition(Area area) throws Exception;

    /**
     * 去重获得所有区域名称
     * @return
     */
    List<String> getAllAreaName() throws Exception;

    /**
     * 根据区域名获得所有小区名
     * @param areaName
     * @return
     */
    List<String> getNeighbourhoodByAreaName(String areaName) throws Exception;
}
