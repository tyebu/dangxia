package com.wxc.dangxia.service.build.impl;

import com.github.pagehelper.PageHelper;
import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.dao.build.IRoomDao;
import com.wxc.dangxia.service.build.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RoomServiceImpl
 * @Author Star.Wu
 * @Date 2019/4/21 20:44
 */
@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomDao roomDao;
    @Override
    public ResultMsg getRoomInfoByCondition(Map<String, Object> data) throws Exception {
        Map<String,Object> map = new HashMap<>();
        int pageNo = Integer.parseInt(data.get("pageNo")+"");
        int pageSize = Integer.parseInt(data.get("pageSize")+"");
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String, Object>> roomList = roomDao.getRoomInfoByCondition(data);
        Integer count = roomDao.getCountByCondition(data);
        return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS, roomList, count);
    }
}
