package com.newweb.common.exception.handler;

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
        ExceptionMapper<Exception> {
  @Override
  public Response toResponse(Exception e) {
    return RestResult.failure(HttpStatus.INTERNAL_SERVER_ERROR_500, e.getMessage());
  }
}