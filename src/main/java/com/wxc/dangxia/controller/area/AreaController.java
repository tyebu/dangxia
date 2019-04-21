package com.wxc.dangxia.controller.area;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.entity.build.Area;
import com.wxc.dangxia.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName AreaController
 * @Author Star.Wu
 * @Date 2019/4/10 21:31
 */
@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping(value = "/getAreaInfo")
    public ResultMsg getAreaInfo() {
        try {
            List<Area> areaInfos = areaService.getAreaInfo();
            return new ResultMsg(StatusCode.LAYUISUCCESS,StatusMessage.SUCCESS,areaInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.LAYUIERROR,StatusMessage.ERROR,null);
        }
    }

    /***
     * 添加位置
     * @param area
     * @return
     */
    @RequestMapping(value = "/insertArea",method = RequestMethod.POST)
    public ResultMsg insertArea(Area area) {
        try{
            Integer rows = areaService.insertArea(area);
            return rows>0? new ResultMsg(StatusCode.LAYUISUCCESS,StatusMessage.ADDSUCCESS):new ResultMsg(StatusCode.LAYUIERROR, StatusMessage.ADDFAIL);
        } catch(CommonException e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.LAYUIERROR,e.getMessage());
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.LAYUIERROR,StatusMessage.ERROR);
        }
    }

    /**
     * 删除位置信息
     * @param areaId
     * @return
     */
    @RequestMapping(value = "/deleteAreaById", method = RequestMethod.POST)
    public ResultMsg deleteAreaById(Integer areaId) {
        try {
            Integer rows = areaService.deleteAreaById(areaId);
            if(rows != null) {
                if(rows > 0) {
                    return new ResultMsg(StatusCode.LAYUISUCCESS,StatusMessage.DELETESUCCESS);
                }
            }
        } catch(CommonException e) {
            return new ResultMsg(StatusCode.ERROR,e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR,StatusMessage.ERROR);
        }
        return new ResultMsg(StatusCode.LAYUIERROR,StatusMessage.DELETEFAIL);
    }

    /***
     * 修改位置信息
     * @param area
     * @return
     */
    @RequestMapping(value = "/updateArea", method = RequestMethod.POST)
    public ResultMsg updateAreaByCondition(Area area) {
        try {
            Integer rows = areaService.updateAreaByCondition(area);
            if(rows > 0) {
                return new ResultMsg(StatusCode.LAYUISUCCESS,StatusMessage.UPDATESUCCESS);
            }
        } catch (CommonException e) {
            return new ResultMsg(StatusCode.ERROR,e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR,StatusMessage.ERROR);
        }
        return new ResultMsg(StatusCode.LAYUIERROR,StatusMessage.UPDATEERROR);
    }

    /**
     * 获得所有位置信息
     * @return
     */
    @RequestMapping(value = "/getAllAreaName", method = RequestMethod.POST)
    public ResultMsg getAllAreaName() {
        try {
            List<String> areaName = areaService.getAreaName();
            return new ResultMsg(StatusCode.SUCCESS,StatusMessage.SUCCESS,areaName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR,StatusMessage.ERROR);
        }
    }

    /***
     * 获得所有小区信息
     * @param areaName
     * @return
     */
    @RequestMapping(value = "getNeighbourhoodByAreaName", method = RequestMethod.POST)
    public ResultMsg getNeighbourhoodByAreaName(String areaName) {
        try {
            return new ResultMsg(StatusCode.SUCCESS,StatusMessage.SUCCESS,areaService.getNeighbourhoodByAreaName(areaName));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR,StatusMessage.ERROR);
        }
    }
}
