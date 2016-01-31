/*
 * Copyright (c) 2015 by XuanWu Wireless Technology Co., Ltd. 
 *             All rights reserved                         
 */
package com.newweb.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * 服务启动程序
 */
@Configuration
@EnableAutoConfiguration
@ImportResource({"classpath*:applicationContext.xml"})
public class RestServer {
	public static void main(String[] args) {
		SpringApplication.run(RestServer.class, args);
	}
}
