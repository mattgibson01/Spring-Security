package com.interview.spring_sec_project.security;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	private static final Logger log = org.apache.log4j.Logger.getLogger(SpringSecurityConfig.class);

	public SpringSecurityConfig() {
		super();
		log.debug("Init Sec Conf");
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("user")
				.password("{bcrypt}$2a$10$43qDindX.0rtaVjpkBCI/ehPPO3JQNjueW9BianLCmBeW4gBzOsQS").roles("USER").build();
		UserDetails admin = User.withUsername("admin")
				.password("{bcrypt}$2a$10$bCpbGwIjdCA188KZsyLEi.DFIlPyzrSjMN3y01wJk16bEXBJuPn/u").roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);

	}

	@Bean
	public RoleHierarchyImpl roleHierarchy() {
		return RoleHierarchyImpl.withDefaultRolePrefix().role("ADMIN").implies("USER").build();

	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/", "/welcome.html").permitAll()
				.requestMatchers("/user/**").hasRole("USER")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()

		).formLogin(
				form -> form
				.loginPage("/loginpage.html")
				.loginProcessingUrl("/login") // Default login endpoint
				.permitAll())
		.logout(
				logout -> logout
				.logoutSuccessUrl("/welcome.html") // Redirect to login page after
				.permitAll())
		.exceptionHandling(exception -> exception.accessDeniedPage("/denied.html"));
		return http.build();
	}

	@Bean
	public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
		return new HandlerMappingIntrospector();
	}
}
