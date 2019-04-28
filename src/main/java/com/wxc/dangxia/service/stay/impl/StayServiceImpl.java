package com.wxc.dangxia.service.stay.impl;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StarPasswod;
import com.wxc.dangxia.commons.utils.StarEncryp;
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
        Map<String, Object> data = new HashMap<>();
        data.put("userPhone",map.get("userPhone"));
        Integer phoneCount = userDao.getCountByCondition(data);
        if(ObjectUtils.isEmpty(map)) {
            throw new CommonException("录入信息不能为空");
        }
        if(phoneCount > 0) {
            throw new CommonException("该手机号已存在！");
        }
        data.put("userPhone",null);
        data.put("userCard",map.get("userCard"));
        Integer cardCount = userDao.getCountByCondition(data);
        if(cardCount > 0) {
            throw  new CommonException("身份证号已存在！");
        }
        //判断选择的房间是否还有空闲
        Map<String, Object> roomInfo = roomDao.getRoomInfoByRoomId(Integer.valueOf(map.get("roomId").toString()));

        map.put("userId",null);
        // 初始化密码
        map.put("password", StarEncryp.encryp(StarPasswod.password));
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
