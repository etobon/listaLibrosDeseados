package com.etobon.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration	
public class MvcConfig implements WebMvcConfigurer {
	
	//Conttrolador parametrizable
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error403").setViewName("/error403");
	}
	
}
