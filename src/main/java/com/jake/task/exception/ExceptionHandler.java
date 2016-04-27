package com.jake.task.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

/**
 * 定时任务异常处理
 * @author jake
 */
@Component
public class ExceptionHandler implements ErrorHandler {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

	@Override
	public void handleError(Throwable t) {
		log.error("处理任务发生异常:" + t.getMessage());
//		t.printStackTrace();
//		throw new RuntimeException("处理任务发生异常", t);
	}

}
