package com.wxc.dangxia.service.rent.impl;

import com.github.pagehelper.PageHelper;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.dao.rent.IRentDao;
import com.wxc.dangxia.dao.user.IUserDao;
import com.wxc.dangxia.service.rent.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/29 17:19
 * @description:
 **/
@Service
public class RentServiceImpl implements IRentService {
    @Autowired
    private IRentDao rentDao;
    @Autowired
    private IUserDao userDao;
    @Override
    public ResultMsg getRentRecordByCondition(Map<String, Object> map) throws Exception {
        int pageNo = Integer.parseInt(map.get("page")+"");
        int pageSize = Integer.parseInt(map.get("limit")+"");
        PageHelper.startPage(pageNo,pageSize);
        Integer count = rentDao.getRentRecordCountByCondition(map);
        List<Map<String, Object>> rentRecordByCondition = rentDao.getRentRecordByCondition(map);
        return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS, rentRecordByCondition, count);
    }

    @Override
    public Map<String, Object> getRentUserInfoByCondition(Map<String, Object> map) throws Exception {

        return userDao.getRentUserInfoByCondition(map);
    }


}
