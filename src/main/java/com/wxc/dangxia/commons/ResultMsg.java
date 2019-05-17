package com.wxc.dangxia.commons;

import lombok.Data;

/**
 * @ClassName ResultMsg
 * @Author Star.Wu
 * @Date 2019/4/7 15:42
 * 返回前台json数据
 */
@Data
public class ResultMsg {
    private Integer code;
    private String msg;
    private Object data;
    private Object message;
    private Integer count;
    public ResultMsg() {

    }
    public ResultMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ResultMsg(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResultMsg(Integer code, String msg, Object data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public ResultMsg(Integer code, String msg, Object data, Object message) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
