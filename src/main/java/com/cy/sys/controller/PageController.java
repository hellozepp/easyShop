package com.cy.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "index";
	}
	
	@RequestMapping("{page}")
	public String doPage(@PathVariable("page") String page) {
		return page;
	}

	// 分页div
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
}
