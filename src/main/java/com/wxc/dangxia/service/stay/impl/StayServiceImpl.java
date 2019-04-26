package com.wxc.dangxia.service.stay.impl;

import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.dao.user.IUserDao;
import com.wxc.dangxia.service.stay.IStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    /**
     * 录入信息
     * @param map
     * @return
     * @throws Exception
     */
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
        Integer count = userDao.getCountByCondition(map);
        return userDao.insertUserInfo(map);
    }

    /**
     * 获得录入的未入住租客信息
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public List<Map<String, Object>> getStayInfoBycondition(Map<String, Object> map) throws Exception {

        return null;
    }
}
