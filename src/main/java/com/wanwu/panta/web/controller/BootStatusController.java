package com.wanwu.panta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootStatusController {

	@RequestMapping(value="/boot/healthcare.page", method=RequestMethod.GET)
	@ResponseBody
	public String loginPage() {
		return "bootSuccess";
	}
}
