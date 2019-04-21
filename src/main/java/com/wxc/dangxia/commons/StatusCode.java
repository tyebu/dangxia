package com.wxc.dangxia.commons;

/**
 * @ClassName StatusCode
 * @Author zfy
 * @Date 2019/4/10 21:48
 */
public interface StatusCode {
    Integer ERROR = 500; // 普通处理错误
    Integer SUCCESS = 200; // 普通处理成功
    Integer FAIL = 301; //失败
    Integer LAYUISUCCESS = 0; // layui成功码
    Integer LAYUIERROR = 1; // layui失败码

}
