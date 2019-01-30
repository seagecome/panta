package com.wanwu.panta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class OrderController {

	@RequestMapping(value="/createOrder", method=RequestMethod.GET)
	public String createOrder() {
		return "responseShow";
	}
	
	@RequestMapping(value="/payOrder", method=RequestMethod.GET)
	public String payOrder() {
		return "responseShow";
	}
	
	@RequestMapping(value="/refundCheck", method=RequestMethod.GET)
	public String refundCheck() {
		return "responseShow";
	}
	
	@RequestMapping(value="/refundQuery", method=RequestMethod.GET)
	public String refundQuery() {
		return "responseShow";
	}
}
