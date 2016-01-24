package com.newweb.server;

import com.newweb.common.exception.handler.WebApplicationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Jersey配置
 */
@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		packages("com.newweb");
		register(WebApplicationExceptionMapper.class);
	}
}