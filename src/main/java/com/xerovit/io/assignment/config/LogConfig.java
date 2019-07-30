package com.xerovit.io.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.xerovit.io.assignment.interceptor.LogInterceptor;

@Configuration
public class LogConfig implements WebMvcConfigurer {

	@Bean
	public LogInterceptor logInterceptor() {
		return new LogInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logInterceptor());
	}
}
