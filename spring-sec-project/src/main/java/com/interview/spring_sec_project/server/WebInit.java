package com.interview.spring_sec_project.server;

import com.interview.spring_sec_project.config.AppConfig;
import com.interview.spring_sec_project.config.WebConfig;
import com.interview.spring_sec_project.security.SpringSecurityConfig;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * WebMVC Initializer
 */
@Order(1)
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { SpringSecurityConfig.class, AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
