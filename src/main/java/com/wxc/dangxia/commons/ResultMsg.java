package com.wxc.dangxia.commons;

/**
 * @ClassName ResultMsg
 * @Author Star.Wu
 * @Date 2019/4/7 15:42
 * 返回前台json数据
 */
public class ResultMsg {
    private Integer code;
    private String msg;
    private Object data;
    private Integer count;
    public ResultMsg() {

    }
    public ResultMsg(Integer code, String mesg) {
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

}
