package com.newweb.constance;

import com.newweb.common.constance.CommonErrorCode;

/**
 * <h6>错误码</h6>
 * <li>按照模块代号开头:-模块号 * 10000 + 错误码</li>
 * Created by Jake on 1/24 0024.
 */
public interface ErrorCode extends CommonErrorCode {


    // ---------------用户模块 1---------------
    /**
     * 用户名或密码错误
     */
    int LOGIN_FAILURE = -10001;

}
