package com.wxc.dangxia.service.build.impl;

import com.github.pagehelper.PageHelper;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.dao.build.ILandlordDao;
import com.wxc.dangxia.service.build.ILandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
