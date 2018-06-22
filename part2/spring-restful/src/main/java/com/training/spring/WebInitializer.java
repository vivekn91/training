package com.training.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// this is for servlet init
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// this is for servlet init
		return new String[]{"/"};
	}

}
