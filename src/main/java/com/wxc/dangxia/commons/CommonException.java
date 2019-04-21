package com.wxc.dangxia.commons;

/**
 * @ClassName CommonException
 * @Author Star.Wu
 * @Date 2019/4/14 17:24
 */
public class CommonException extends RuntimeException{
    public CommonException() {
        super();
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    protected CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
