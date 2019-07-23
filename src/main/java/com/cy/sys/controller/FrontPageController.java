package com.cy.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front/")
public class FrontPageController {
	
	@RequestMapping("{page}")
	public String doPage(@PathVariable("page") String page) {
		return "front/"+page;
	}
	
	@RequestMapping("doLoadGoodsUI")
	public String doLoadGoodsUI(Integer goodtype_id) {
		return "front/goods_list";
	}
}
