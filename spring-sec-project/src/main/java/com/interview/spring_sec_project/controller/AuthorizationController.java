package com.interview.spring_sec_project.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Mappings in Authorized Zones
 */
@Controller
public class AuthorizationController {

	private static final Logger log = org.apache.log4j.Logger.getLogger(AuthorizationController.class);

	@RequestMapping("/denied.html")
	public String denied() {
		log.debug("User Denied Access");
		return "denied";
	}

	@RequestMapping("/admin/admin.html")
	public String admin() {
		log.debug("Entering Admin Page");
		return "admin/admin.html";
	}

	@RequestMapping("/user/user.html")
	public String user() {
		log.debug("Entering Auth User Page");
		return "user/user.html";
	}

}
