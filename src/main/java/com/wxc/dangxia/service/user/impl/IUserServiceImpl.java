package com.wxc.dangxia.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.wxc.dangxia.commons.CommonException;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StarEncryp;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.dao.user.IUserDao;
import com.wxc.dangxia.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
        int pageNo = Integer.parseInt(map.get("page")+"");
        int pageSize = Integer.parseInt(map.get("limit")+"");
        PageHelper.startPage(pageNo,pageSize);
        Integer count = userDao.getCountByCondition(map);
        List<Map<String, Object>> userInfoByCondition = userDao.getUserInfoByCondition(map);

        return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS, userInfoByCondition, count);
    }

    /***
     * 根据用户id删除用户
     * @param map
     * @return
     */
    @Override
    public Integer deleteUserByUserId(Map<String, Object> map) throws Exception {
        //判断该用户状态是否还在入住
        Object userId = map.get("userId");
        map.put("isDel",true);
        if(!ObjectUtils.isEmpty(userId)) {
            Integer status = userDao.getUserStatusByUserId(Integer.valueOf(userId.toString()));
            if(status == 1) {
                throw new CommonException("该用户还在入住中。");
            }
        }
        return userDao.updateUserByCondition(map);
    }

    @Override
    public Map<String, Object> getUserInfoByUserId(Map<String, Object> map) throws Exception {
        List<Map<String, Object>> userInfoByCondition = userDao.getUserInfoByCondition(map);
        if(ObjectUtils.isEmpty(userInfoByCondition)) {
            throw new Exception("该用户不存在");
        }
        Map<String, Object> user = userInfoByCondition.get(0);
        String password = StarEncryp.decrypt(user.get("password").toString());
        user.put("password",password);
        return user;
    }

    /**
     * 根据条件修改用户信息
     * @param map
     * @return
     */
    @Override
    public Integer updateUser(Map<String, Object> map) throws Exception {
        String password = StarEncryp.encryp(map.get("password").toString());
        Map<String, Object> data = map;
        String userSex = map.get("userSex").toString();
        Boolean sex;
        if(userSex.equals("0")) {
            sex = false;
        } else{
            sex = true;
        }
        data.put("userSex",sex);

        data.put("password",password);
        Integer rows = userDao.updateUserByCondition(data);
        if(rows == null || rows <= 0) {
            throw new CommonException("修改失败");
        }
        return rows;
    }
}
