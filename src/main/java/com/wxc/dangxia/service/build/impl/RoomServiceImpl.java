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
import org.springframework.util.ObjectUtils;

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
        if(ObjectUtils.isEmpty(data)) {
            throw new CommonException("提交数据不能为空。");
        }
        if(ObjectUtils.isEmpty(data.get("roomNum"))) {
            throw new CommonException("房间号不能为空");
        }
        if(ObjectUtils.isEmpty(data.get("buildingId"))) {
            throw new CommonException("房间号不能为空");
        }
        //首先根据条件获的房间信息，查询是否有相同条件的房间
        Integer roomCount = roomDao.getCountByCondition(data);
        //若roomCount大于0就表示已存在相同条件的房间，抛出异常
        if(roomCount > 0) {
            throw new CommonException("已存在同条件房间，请检查关键字段。");
        }
        Object roomSize = data.get("roomSize");
        if(ObjectUtils.isEmpty(roomSize)) {
            data.put("roomSize",null);
        }
        return roomDao.insertRoomInfo(data);
    }

    /***
     * 获的房间类型
     * @param map
     * @return
     */
    @Override
    public List<Map<String, Object>> getRoomType(Map<String, Object> map) throws Exception {
        List<Map<String, Object>> roomType = roomDao.getRoomType(map);
        return roomType;
    }

    @Override
    public ResultMsg getRoomListByCondition(Map<String, Object> map) throws Exception {
        List<Map<String, Object>> roomList = roomDao.getRoomInfoByCondition(map);
        return new ResultMsg(StatusCode.LAYUISUCCESS, StatusMessage.SUCCESS, roomList);
    }

    @Override
    public Integer deleteRoomById(Map<String, Object> map) throws Exception {
        //判断该房间下是否还有租客
        Map<String, Object> data = roomDao.getRoomInfoByRoomId(Integer.valueOf(map.get("roomId").toString()));
        Integer people_num = Integer.valueOf(data.get("people_num").toString());
        if(people_num > 0) {
            throw new CommonException("该房间中还有租客。");
        }
        map.put("isDel",true);
        Integer rows = roomDao.updateRoomInfo(map);
        if(rows == null || rows <= 0) {
            throw new CommonException("删除失败");
        }
        return rows;
    }

    /**
     * 根据房间id获得房间信息
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> getRoomInfoByRoomId(Map<String, Object> map) throws Exception {
        return roomDao.getRoomInfoByCondition(map).get(0);
    }

    /**
     * 修改房间信息
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateRoomInfo(Map<String, Object> map) throws Exception {
        if(ObjectUtils.isEmpty(map)) {
            throw new CommonException("信息不能为空。");
        }
        if(ObjectUtils.isEmpty(map.get("roomNum"))) {
            throw new CommonException("房间号不能为空。");
        }
        if(ObjectUtils.isEmpty(map.get("roomArea"))) {
            throw new CommonException("房间大小不能为空。");
        }
        if(ObjectUtils.isEmpty(map.get("peopleRent"))) {
            throw new CommonException("租客应缴租金不能为空。");
        }
        if(ObjectUtils.isEmpty(map.get("roomRent"))) {
            throw new CommonException("房间租金不能为空。");
        }
        Integer rows = roomDao.updateRoomInfo(map);
        if(rows <= 0) {
            throw new CommonException("修改失败");
        }
        return rows;
    }
}
