package com.wxc.dangxia.service.build.impl;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.dao.area.IAreaDao;
import com.wxc.dangxia.dao.build.IBuildingDao;
import com.wxc.dangxia.dao.build.IRoomDao;
import com.wxc.dangxia.entity.build.Area;
import com.wxc.dangxia.entity.build.Building;
import com.wxc.dangxia.service.build.IBuildingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BuildingsServiceImpl
 * @Author Star.Wu
 * @Date 2019/4/7 15:52
 */
@Service
public class BuildingsServiceImpl implements IBuildingsService {
    @Autowired(required = true)
    private IBuildingDao buildingDao;

    @Autowired
    private IRoomDao roomDao;

    @Autowired
    private IAreaDao areaDao;
    /**
     * 根据条件获得分页数据
     * @param data
     * @return
     */
    @Override
    public List<Building> getBuildingsByCondition(Map<String, Object> data) throws Exception {
        List<Building> buildings = buildingDao.getBuildingsByCondition(data);
        return buildings;
    }

    /***
     * 添加楼栋信息
     * @param data
     * @return
     */
    @Override
    public Integer insertBuilding(Map<String, Object> data) throws Exception {
        if(ObjectUtils.isEmpty(data.get("areaName")) || ObjectUtils.isEmpty(data.get("neighbourhood")) || ObjectUtils.isEmpty(data.get("buildingName"))) {
            throw  new CommonException("数据项不能为空。");
        }
        Area area = new Area();

        area.setAreaName(String.valueOf(data.get("areaName")));
        area.setNeighbourhood(String.valueOf(data.get("neighbourhood")));
        Integer areaId = areaDao.getIdByAreaNameAndNeighbourhood(area);
        if(areaId == null) {
            throw  new CommonException("该位置不存在");
        }
        data.put("areaId",areaId);
        List<Building> buildings = buildingDao.getBuildingsByCondition(data);
        if(!ObjectUtils.isEmpty(buildings) && buildings.size() > 0) {
            throw new CommonException("该楼栋已存在");
        }
        return buildingDao.insertBuilding(data);
    }

    /**
     * 根据id删除楼栋
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public Integer deleteBuildingById(Map<String, Object> map) throws Exception {
        Integer roomCount = roomDao.getRoomCountByBuildingId(map);
        if(roomCount > 0) {
            throw new CommonException("该楼栋下还有房间");
        }
        map.put("isDel",true);
        Integer rows = buildingDao.updateBuilding(map);
        if(rows ==null || rows <= 0) {
            throw new CommonException("删除失败。");
        }
        return rows;
    }

}
