package com.newweb.common.exception;

/**
 * 系统运行时异常基类
 * Created by Jake on 1/17 0017.
 */
public class EbaseRuntimeException extends RuntimeException  {

    public EbaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
