package com.wxc.dangxia.service.rent.impl;

import com.github.pagehelper.PageHelper;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.dao.rent.IRentDao;
import com.wxc.dangxia.dao.stay.IStayDao;
import com.wxc.dangxia.dao.user.IUserDao;
import com.wxc.dangxia.service.rent.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private IStayDao stayDao;
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

    /**
     * 获得待交租房客列表
     * @param map
     * @return
     */
    @Override
    public ResultMsg getToPayRentUser(Map<String, Object> map) throws Exception {
        int pageNo = Integer.parseInt(map.get("page")+"");
        int pageSize = Integer.parseInt(map.get("limit")+"");
        PageHelper.startPage(pageNo,pageSize);
        Integer count = userDao.getToPayRentCount(map);

        List<Map<String, Object>> data = userDao.getToPayRentUser(map);
        return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS, data, count);
    }

    /**
     * 缴纳租金
     * @param map
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultMsg payRent(Map<String, Object> map) throws Exception {
        //修改入住记录中该用户的endDate
        stayDao.updateStayRecord(map);
        //向交租记录表中插入数据
        rentDao.insertRentRecord(map);
        return new ResultMsg(StatusCode.SUCCESS, StatusMessage.RENT_SUCCESS);
    }


}
