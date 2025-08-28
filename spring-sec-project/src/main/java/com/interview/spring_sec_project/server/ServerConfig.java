package com.interview.spring_sec_project.server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "com.interview.spring_sec_project.server" })
@PropertySource("classpath:server.properties")
public class ServerConfig {
}
