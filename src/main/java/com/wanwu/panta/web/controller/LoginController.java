package com.wanwu.panta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value="/login.page", method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login/check", method=RequestMethod.POST)
	public String loginCheck() {
		System.out.println("登陆成功后续操作");
		return "success";
	}
	
	
}
