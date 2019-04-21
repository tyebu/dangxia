package com.wxc.dangxia.entity.build;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Landlord
 * @Author Star.Wu
 * @Date 2019/4/21 16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Landlord {
    private Integer landlordId;
    private String landlordName;
    private String landlordPhone;
    private Integer landlordSex;
    private String landlordAddress;
    private String agreementNum;
    private String createdUser;
    private Date createdDate;
    private String modifyUser;
    private Date modifyDate;
    private Boolean isDel;
}
