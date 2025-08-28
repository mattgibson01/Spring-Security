package com.interview.spring_sec_project.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Controller for Mappings that deal with Authentication
 */
@Controller
public class AuthenticationController {

	private static final Logger log = org.apache.log4j.Logger.getLogger(AuthenticationController.class);

	SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

	@RequestMapping("/")
	public String root() {
		log.debug("Entering Root Request");
		return "redirect:/welcome.html";
	}

	@GetMapping("/loginpage.html")
	public String login() {
		log.debug("Redirecting to login page");
		return "loginpage";
	}

	@RequestMapping("/welcome.html")
	public String welcome() {
		log.debug("Entering Welcome Page");
		return "welcome";
	}

	@PostMapping("/logout")
	public String performLogout(Authentication authentication, HttpServletRequest request,
			HttpServletResponse response) {
		log.debug("Logging " + authentication.getName() + " out");
		this.logoutHandler.logout(request, response, authentication);
		return "redirect:/welcome.html";

	}
}
