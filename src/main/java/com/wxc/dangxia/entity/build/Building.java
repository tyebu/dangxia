package com.wxc.dangxia.entity.build;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName Buildings
 * @Author Star.Wu
 * @Date 2019/4/7 15:55
 * 楼栋单元实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    private Integer buildingId;
    private String buildingName;
    private Area area;
    private String createdUser;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    private String modifyUser;
    private Date modifyDate;
    private Boolean isDel;
}
