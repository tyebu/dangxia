package com.wxc.dangxia.dao.build;

import com.wxc.dangxia.entity.build.Building;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IBuildingDao
 * @Author zfy
 * @Date 2019/4/7 16:03
 * 楼栋单元数据层
 */
@Mapper
@Component
public interface IBuildingDao {
    /**
     * 根据条件获得buildings
     * @param data
     * @return
     */
    List<Building> getBuildingsByCondition(Map<String, Object> data) throws  Exception;

    /***
     * 添加楼栋信息
     * @param data
     * @return
     */
    Integer insertBuilding(Map<String,Object> data) throws  Exception;

    /**
     * 修改楼栋信息
     * @param data
     * @return
     */
    Integer updateBuilding(Map<String,Object> data) throws Exception;

    /**
     * 根据id删除楼栋
     * @param buildingId
     * @return
     */
    Integer deleteBuildingByBuildingId(Integer buildingId) throws  Exception;
}
