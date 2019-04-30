package com.wxc.dangxia.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.dao.user.IUserDao;
import com.wxc.dangxia.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: Star.Wu
 * @date: 2019/4/26 09:48
 * @description:
 **/
@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    /**
     * 分页获取租客数据
     * @param map
     * @return
     */
    @Override
    public ResultMsg getUserInfoByCondition(Map<String, Object> map) throws Exception {
        Map<String,Object> data = new HashMap<>();
        int pageNo = Integer.parseInt(map.get("page")+"");
        int pageSize = Integer.parseInt(map.get("limit")+"");
        PageHelper.startPage(pageNo,pageSize);
        Integer count = userDao.getCountByCondition(map);
        List<Map<String, Object>> userInfoByCondition = userDao.getUserInfoByCondition(map);

        return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS, userInfoByCondition, count);
    }

    /***
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    @Override
    public Integer deleteUserByUserId(Integer userId) {
        return null;
    }
}
