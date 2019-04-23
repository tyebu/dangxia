package com.wxc.dangxia.service.build.impl;

import com.github.pagehelper.PageHelper;
import com.wxc.dangxia.commons.CommonException;
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
        int pageNo = Integer.parseInt(data.get("page")+"");
        int pageSize = Integer.parseInt(data.get("limit")+"");
        PageHelper.startPage(pageNo,pageSize);

        Integer count = roomDao.getCountByCondition(data);
        List<Map<String, Object>> roomList = roomDao.getRoomInfoByCondition(data);
        return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS, roomList, count);
    }

    /**
     * 添加房间信息
     * @param data
     * @return
     */
    @Override
    public Integer insertRoomInfo(Map<String, Object> data) throws Exception {
        //首先根据条件获的房间信息，查询是否有相同条件的房间
        Integer roomCount = roomDao.getCountByCondition(data);
        //若roomCount大于0就表示已存在相同条件的房间，抛出异常
        if(roomCount > 0) {
            throw new CommonException("已存在同条件房间，请检查关键字段。");
        }
        return roomDao.insertRoomInfo(data);
    }
}
