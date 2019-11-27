package com.expense.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expense.core.base.controller.BaseController;

@Controller
public class IndexController extends BaseController{

	public IndexController(HttpServletRequest request) {
		super(request);
	}

	@RequestMapping("/")
	@ResponseBody 
	public String home() {
		return "login";
	}
}
