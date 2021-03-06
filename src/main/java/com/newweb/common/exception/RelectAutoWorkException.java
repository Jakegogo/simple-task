package com.newweb.common.exception;

import com.newweb.common.constance.CommonErrorCode;

/**
 * 反射自动化处理异常
 * Created by Jake on 1/17 0017.
 */
public class RelectAutoWorkException extends EbaseRuntimeException {

    /**
     * 构造方法
     * @param message 提示消息
     * @param cause 源异常
     */
    public RelectAutoWorkException(String message, Throwable cause) {
        super(CommonErrorCode.REFLECT_WORK_EXCEPTION, message, cause);
    }

}
