package com.newweb.common.exception;

import com.newweb.common.constance.CommonErrorCode;

/**
 * 数据权限异常
 * Created by Administrator on 2016-1-29.
 */
public class DataSecurityException extends EbaseRuntimeException {

    /**
     * 构造方法
     * @param message 提示
     * @param cause 源异常
     */
    public DataSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造方法
     * @param errorCode 错误码
     * @param message 提示
     * @param cause 源异常
     */
    public DataSecurityException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    /**
     * 抛出数据权限异常
     * @param message 提示
     * @throws BusinessException
     */
    public static void throwIt(String message) throws BusinessException {
        throw new DataSecurityException(CommonErrorCode.DATA_SECURE, message, null);
    }

    /**
     * 抛出数据权限异常
     * @param message 提示
     * @param cause 源异常
     * @throws BusinessException
     */
    public static void throwIt(String message, Throwable cause) throws BusinessException {
        throw new DataSecurityException(CommonErrorCode.DATA_SECURE, message, cause);
    }

}
