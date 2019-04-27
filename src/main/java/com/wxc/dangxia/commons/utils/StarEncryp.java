package com.wxc.dangxia.commons.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @ClassName Myencryp
 * @Author Star.Wu
 * @Date 2019/4/27 17:29
 */
public class StarEncryp {
    /***
     * 对数据加密
     * @return
     */
    public static String encryp(String msg){
        return Base64.encode(msg.getBytes());
    }

    /**
     * 对数据解密
     * @return
     */
    public static String decrypt(String msg) {
        byte[] decode = Base64.decode(msg);
        return new String(decode);
    }
}
