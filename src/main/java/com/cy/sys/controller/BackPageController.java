package com.cy.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back/")
public class BackPageController {

	@RequestMapping("{page}")
	public String doPage(@PathVariable("page") String page) {
		return "back/"+page;
	}

}
