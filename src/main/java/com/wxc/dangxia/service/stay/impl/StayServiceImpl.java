package com.wxc.dangxia.service.stay.impl;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.dao.build.IRoomDao;
import com.wxc.dangxia.dao.deposit.IDepositDao;
import com.wxc.dangxia.dao.rent.IRentDao;
import com.wxc.dangxia.dao.stay.IStayDao;
import com.wxc.dangxia.dao.user.IUserDao;
import com.wxc.dangxia.service.stay.IStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/26 13:29
 * @description:
 **/
@Service
public class StayServiceImpl implements IStayService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IRoomDao roomDao;
    @Autowired
    private IRentDao rentDao;
    @Autowired
    private IStayDao stayDao;
    @Autowired
    private IDepositDao depositDao;
    /**
     * 录入信息
     * @param map
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer insertStayInfo(Map<String, Object> map) throws Exception {
        Integer phoneCount = userDao.getCountByCondition((Map<String, Object>) new HashMap<String, Object>().put("userPhone", map.get("userPhone")));
        if(ObjectUtils.isEmpty(map)) {
            throw new Exception("录入信息不能为空");
        }
        if(phoneCount > 0) {
            throw new CommonException("该手机号已存在！");
        }
        Integer cardCount = userDao.getCountByCondition((Map<String, Object>) new HashMap<String, Object>().put("userCard", map.get("userCard")));
        if(cardCount > 0) {
            throw  new Exception("身份证号已存在！");
        }
        map.put("userId",null);
        userDao.insertUserInfo(map);

        //向用户房间表插入数据
        roomDao.insertRoomUser(map);
        //向交租表插入数据
        rentDao.insertRentRecord(map);
        //向入住记录表插入数据
        stayDao.insertStayRecord(map);
        //向押金记录表插入信息
        return depositDao.insertUserDeposit(map);
    }

    /**
     * 获得入住记录
     * @param map
     * @return
     */
    @Override
    public ResultMsg getStayRecordByCondition(Map<String, Object> map) {
        stayDao.getStayRecordByCondition(map);
        return null;
    }
}
