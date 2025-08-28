package com.interview.spring_sec_project;

import org.apache.catalina.LifecycleException;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import jakarta.servlet.ServletException;

import com.interview.spring_sec_project.server.ServerConfig;

/**
 * Main method for starting Spring program, initializes Spring Container
 *
 */
public class App {

	private static final Logger log = org.apache.log4j.Logger.getLogger(App.class);

	public static void main(String[] args) throws LifecycleException, ServletException {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
			ctx.register(ServerConfig.class);
			ctx.refresh();
			log.debug("Server Config Registered!");
			ctx.start();
		} catch (BeansException | IllegalStateException e) {
			e.printStackTrace();
		}
	}
}
