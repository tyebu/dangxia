package com.wxc.dangxia.service.leave.impl;

import com.wxc.dangxia.commons.ResultMsg;
import com.wxc.dangxia.commons.StatusCode;
import com.wxc.dangxia.commons.utils.StatusMessage;
import com.wxc.dangxia.dao.build.IRoomDao;
import com.wxc.dangxia.dao.leave.ILeaveDao;
import com.wxc.dangxia.dao.stay.IStayDao;
import com.wxc.dangxia.dao.user.IUserDao;
import com.wxc.dangxia.service.leave.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName LeaveServiceImpl
 * @Author Star.Wu
 * @Date 2019/5/4 16:50
 */
@Service
public class LeaveServiceImpl implements ILeaveService {
    @Autowired
    private ILeaveDao leaveDao;
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IStayDao stayDao;

    @Autowired
    private IRoomDao roomDao;
    @Override
    public Map<String, Object> getLeaveUserInfoByUserCard(Map<String, Object> map) throws Exception {
        Map<String, Object> leaveUserInfo = leaveDao.getLeaveUserInfoByUserCard(map);

        return leaveUserInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultMsg userLeave(Map<String, Object> map) throws Exception {
        //首先把把user表中的用户状态改为已退宿
        map.put("live_status",2);
        Integer r1 = userDao.updateUserByCondition(map);
        //修改入住记录表
        map.put("endDate",new Date());
        stayDao.updateStayRecord(map);
        //根据roomId修改房间表人数
        roomDao.roomPeopleMinus(map);
        //删除用户房间表的对应数据
        roomDao.deleteRoomUserByUserId(map);
        return new ResultMsg(StatusCode.SUCCESS, StatusMessage.LEAVESUCCESS);
    }
}
