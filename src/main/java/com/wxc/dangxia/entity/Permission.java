package com.wxc.dangxia.entity;

import lombok.Data;

import java.util.Date;
/**
 * 权限表实体
 *
 * @author Star.Wu
 * @date 2019/05/09
 */
@Data
public class Permission {
    private Integer id;

    private String permiTitle;

    private String permiName;

    private String permiUrl;

    private String permiDescribe;

    private Integer permiParentId;

    private Integer permiType;

    private Date createtime;

    private Integer status;

    private Integer seq;

}