package com.wxc.dangxia.commons;

/**
 * @ClassName ResultMsg
 * @Author Star.Wu
 * @Date 2019/4/7 15:42
 * 返回前台json数据
 */
public class ResultMsg {
    private Integer code;
    private String message;
    private Object data;
    private Integer count;
    public ResultMsg() {

    }
    public ResultMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public ResultMsg(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public ResultMsg(Integer code, String message, Object data, Integer count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
