package com.wxc.dangxia.service.build.impl;

import com.wxc.dangxia.dao.build.ILandlordDao;
import com.wxc.dangxia.service.build.ILandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Map<String, Object>> getLandlordInfoByCondition(Map<String, Object> map) {
        return null;
    }

    /**
     * 返回房东列表
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public List<Map<String, Object>> getLandlordList(Map<String, Object> map) throws Exception {
        return landlordDao.getLandlordInfoByCondition(map);
    }
}
