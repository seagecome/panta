package com.wanwu.panta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/loginSuccess.page", method=RequestMethod.GET)
	public String loginSuccess() {
		return "loginSuccess";
	}
	
	@RequestMapping(value="/loginFail.page", method=RequestMethod.GET)
	public String loginFail() {
		return "loginFail";
	}
	
	@RequestMapping(value="/accessDenied.page", method=RequestMethod.GET)
	public String accessDenied() {
		return "accessDenied";
	}
	
}
