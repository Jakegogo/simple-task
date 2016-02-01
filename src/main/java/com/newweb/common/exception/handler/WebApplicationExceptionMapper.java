package com.newweb.common.exception.handler;

import com.newweb.common.constance.CommonErrorCode;
import com.newweb.common.exception.EbaseRuntimeException;
import com.newweb.common.util.rest.RestResult;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 统一异常处理
 */
@Provider
public class WebApplicationExceptionMapper implements
        ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable e) {
    // 自定义业务异常
    if (e instanceof EbaseRuntimeException) {
      return RestResult.failure(((EbaseRuntimeException) e).getErrorCode(), e.getMessage());
    }
    // 参数异常
    if (e instanceof IllegalArgumentException) {
      return RestResult.failure(CommonErrorCode.ILLEGAL_ARGUMENT, e.getMessage());
    }
    // 未知异常
    return RestResult.failure(CommonErrorCode.UNKNOW, e.getMessage());
  }

}