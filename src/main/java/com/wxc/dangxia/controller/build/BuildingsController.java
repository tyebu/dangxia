package com.wxc.dangxia.controller.build;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.controller.base.BaseController;
import com.wxc.dangxia.entity.build.Building;
import com.wxc.dangxia.service.build.IBuildingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BuildingsController
 * @Author Star.Wu
 * @Date 2019/4/7 15:16
 */
@Controller
@RequestMapping("/buildings")
public class BuildingsController extends BaseController {
    @Autowired
    private IBuildingsService buildingsService;
    @RequestMapping("/toBuildings")
    public String toBuildings() {
        return "build/buildings";
    }
    /**
     * 获得指定条件的单元信息
     * @return
     */
    @RequestMapping(value = "/getBuildingsByCondition",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultMsg getBuildingsByCondition(@RequestParam Map<String,Object> data) {
        List<Building> buildings = null;
        try {
            buildings = buildingsService.getBuildingsByCondition(data);
            return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS, buildings);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.ERROR, null);
        }
    }

    @RequestMapping(value = "/insertBuilding", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResultMsg insertBuilding(@RequestParam Map<String, Object> data) {
        try {
            Integer rows = buildingsService.insertBuilding(data);
            return new ResultMsg(StatusCode.SUCCESS,StatusMessage.ADDSUCCESS);
        } catch (CommonException e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR,e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }

    /**
     * 根据id删除楼栋
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleteBuildingById", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg deleteBuildingById(@RequestParam  Map<String, Object> map) {
        try {
            Integer rows = buildingsService.deleteBuildingById(map);
            return new ResultMsg(StatusCode.SUCCESS, StatusMessage.DELETESUCCESS);
        } catch(CommonException e){
            return new ResultMsg(StatusCode.ERROR, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(StatusCode.ERROR, StatusMessage.ERROR);
        }
    }
}
