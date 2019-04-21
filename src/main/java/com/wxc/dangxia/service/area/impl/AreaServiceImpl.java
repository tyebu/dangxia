package com.wxc.dangxia.service.area.impl;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.dao.area.IAreaDao;
import com.wxc.dangxia.dao.build.IBuildingDao;
import com.wxc.dangxia.entity.build.Area;
import com.wxc.dangxia.entity.build.Building;
import com.wxc.dangxia.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AreaServiceImpl
 * @Author Star.Wu
 * @Date 2019/4/10 21:34
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private IAreaDao areaDao;
    @Autowired
    private IBuildingDao buildingDao;
    @Override
    public List<Area> getAreaInfo() throws Exception {
        List<Area> areaInfo = areaDao.getAreaInfo();
        return areaInfo;
    }

    @Override
    public Integer insertArea(Area area) throws Exception {
        Integer areaId = areaDao.getIdByAreaNameAndNeighbourhood(area);
        if(areaId == null) {
            return areaDao.insertArea(area);
        } else{
            throw new CommonException("该位置已存在");
        }

    }

    /**
     * 根据id删除位置
     * @param areaId
     * @return
     */
    @Override
    public Integer deleteAreaById(Integer areaId) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("areaId",areaId);
        List<Building> buildingsByCondition = buildingDao.getBuildingsByCondition(map);
        if(buildingsByCondition.size() > 0) {
            throw new CommonException("该位置已被占用");
        }else {
            return areaDao.deleteAreaById(areaId);
        }
    }
    /***
     * 修改位置信息
     * @param area
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateAreaByCondition(Area area) throws Exception {
        if(ObjectUtils.isEmpty(area)) {
            throw new CommonException("修改数据不能为空");
        }
        return areaDao.updateAreaByCondition(area);
    }

    @Override
    public List<String> getAreaName() throws Exception {
        return areaDao.getAllAreaName();
    }

    @Override
    public List<String> getNeighbourhoodByAreaName(String areaName) throws Exception {
        return areaDao.getNeighbourhoodByAreaName(areaName);
    }

}
