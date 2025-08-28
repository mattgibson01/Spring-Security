package com.interview.spring_sec_project.security;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(2) // Filters declared at the Dispatcher initializer should be registered first
public class SpringSecurityWebInit extends AbstractSecurityWebApplicationInitializer {

	private static final Logger log = org.apache.log4j.Logger.getLogger(SpringSecurityWebInit.class);

	public SpringSecurityWebInit() {
		super();
		log.debug(SpringSecurityWebInit.class.getName() + " Initialized");
	}

}
