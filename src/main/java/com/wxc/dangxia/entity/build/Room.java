package com.wxc.dangxia.entity.build;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Room
 * @Author Star.Wu
 * @Date 2019/4/21 16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Integer roomId;
    //房间号
    private Integer roomNum;
    //几人间
    private Integer roomSize;
    //房间类型
    private Integer roomTypeId;
    //已住人数
    private Integer peopleNum;
    //租金
    private Double roomRent;
    //应收租金
    private Double peopleRent;
    //房东信息
    private Landlord landlord;
    //楼栋信息
    private Building building;

    private String createdUser;
    private Date createdDate;
    private String modifyUser;
    private Date modifyDate;
    private Boolean isDel;
}
