package com.wxc.dangxia.entity;

import lombok.Data;

import java.util.Date;

/**
 * 操作日志表实体
 *
 * @author Star.Wu
 * @date 2018/12/25
 */
@Data
public class OperationLog {
    private Integer id;
    private String username;
    private String operateType;
    private String description;
    private String method;
    private String params;
    private String ip;
    private Date createDate;
}
