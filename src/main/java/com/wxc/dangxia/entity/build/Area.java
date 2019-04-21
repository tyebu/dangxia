package com.wxc.dangxia.entity.build;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Area
 * @Author Star.Wu
 * @Date 2019/4/7 16:38
 * 区域
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    private Integer areaId;
    private String areaName;
    private String neighbourhood;
    private String createdUser;
    private Date createdDate;
    private String modifyUser;
    private Date modifyDate;

}
