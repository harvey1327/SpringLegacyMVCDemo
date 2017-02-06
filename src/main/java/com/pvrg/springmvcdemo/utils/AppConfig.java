package com.pvrg.springmvcdemo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages="com.pvrg.springmvcdemo.controller")
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public InternalResourceViewResolver getIRVR(){
		System.out.println("getIRVR()");
		InternalResourceViewResolver iRVR = new InternalResourceViewResolver();
		iRVR.setPrefix("/WEB-INF/views/");
		iRVR.setSuffix(".jsp");
		return iRVR;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		System.out.println("addResourceHandlers()");
		registry.addResourceHandler("/myResources/**").addResourceLocations("/resources");
	}
}
