package com.rodrigo.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rodrigo.component.RequestTimeInterceptor;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor RTI; 
	
		
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(RTI);
	}

	
}
