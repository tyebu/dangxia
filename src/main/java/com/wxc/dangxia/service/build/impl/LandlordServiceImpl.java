package com.wxc.dangxia.service.build.impl;

import com.github.pagehelper.PageHelper;
import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.dao.build.ILandlordDao;
import com.wxc.dangxia.service.build.ILandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/24 10:00
 * @description:
 **/
@Service
public class LandlordServiceImpl implements ILandlordService {
    @Autowired
    private ILandlordDao landlordDao;
    @Override
    public ResultMsg getLandlordInfoByCondition(Map<String, Object> map) throws Exception {
        Map<String,Object> data = new HashMap<>();
        int pageNo = Integer.parseInt(map.get("page")+"");
        int pageSize = Integer.parseInt(map.get("limit")+"");
        PageHelper.startPage(pageNo,pageSize);
        Integer count = landlordDao.getCountByCondition(map);
        List<Map<String, Object>> landlordList = landlordDao.getLandlordInfoByCondition(map);
        return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS, landlordList, count);
    }

    /**
     * 返回房东列表
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public List<Map<String, Object>> getLandlordList() {
        return landlordDao.getLandlordList();
    }

    @Override
    public Integer getCountByCondition(Map<String, Object> map) throws Exception {
        return landlordDao.getCountByCondition(map);
    }

    /**
     * 添加房东
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public Integer insertLandlord(Map<String, Object> map) throws Exception {
        if(ObjectUtils.isEmpty(map)) {
            throw new CommonException("不能为空");
        }
        if(ObjectUtils.isEmpty(map.get("landlordName"))) {
            throw new CommonException("房东姓名不能为空。");
        }
        if(ObjectUtils.isEmpty(map.get("landlordPhone"))) {
            throw new CommonException("房东电话不能为空。");
        }
        Boolean landlordSex = Boolean.valueOf(map.get("landlordSex").toString());
        map.put("landlordSex",landlordSex);
        Integer count = landlordDao.getCountByCondition(map);
        if(count > 0) {
            throw new CommonException("该房东已存在");
        }
        return landlordDao.insertLandlord(map);
    }

    /**
     * 根据房东id删除房东
     * @param map
     * @return
     */
    @Override
    public Integer deleteLandlordById(Map<String, Object> map) throws Exception {
        Integer count = landlordDao.getCountByCondition(map);
        if(count == null || count <= 0) {
            throw new CommonException("该房东不存在。");
        }
        List<Map<String, Object>> landlordInfoByCondition = landlordDao.getLandlordInfoByCondition(map);
        String roomCount = landlordInfoByCondition.get(0).get("roomCount").toString();
        if(Integer.valueOf(roomCount) > 0) {
            throw new CommonException("该房东下还有出租房。");
        }
        map.put("isDel",true);
        Integer rows = landlordDao.updateLandlordByCondition(map);
        if(rows == null || rows <= 0) {
            throw new CommonException("系统异常，删除失败。");
        }
        return rows;
    }

    /**
     * 根据房东id获得房东信息
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> getLandlordByLandlordId(Map<String, Object> map) throws Exception {
        List<Map<String, Object>> landlordInfoByCondition = landlordDao.getLandlordInfoByCondition(map);

        return landlordInfoByCondition.get(0);
    }

    @Override
    public Integer updateLandlordByCondition(Map<String, Object> map) throws Exception {
        if(ObjectUtils.isEmpty(map)) {
            throw new CommonException("修改值不能为空");
        }
        if(ObjectUtils.isEmpty(map.get("landlordName"))) {
            throw new CommonException("房东姓名不能为空");
        }
        if(ObjectUtils.isEmpty(map.get("landlordPhone"))) {
            throw new CommonException("房东电话不能为空");
        }
        Map<String, Object> data = map;
        String landlordSex = map.get("landlordSex").toString();
        Boolean sex;
        if(landlordSex.equals("0")) {
            sex = false;
        } else{
            sex = true;
        }
        data.put("landlordSex",sex);
        Integer rows = landlordDao.updateLandlordByCondition(data);
        return rows;
    }
}
