package com.interview.spring_sec_project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Main Configuration for the Spring root context
 */
@Configuration
@ComponentScan("com.interview.spring_sec_project.service")
public class AppConfig {
}
