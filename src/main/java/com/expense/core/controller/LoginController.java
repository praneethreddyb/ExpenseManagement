package com.expense.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.core.base.controller.BaseController;
import com.expense.core.response.entity.ResponseEntity;
import com.expense.core.service.LoginService;
import com.expense.core.util.Util;
import com.expense.core.util.ZcMap;
import com.expense.core.validations.Validation;


@RestController
public class LoginController extends BaseController{
	
	@Autowired
	LoginService loginService;
	
	public LoginController(HttpServletRequest request) {
		super(request);
	}

	@SuppressWarnings("serial")
	@RequestMapping(path = "/" , method = RequestMethod.GET)
	public ResponseEntity demoService(@PathVariable String message){
		return new ResponseEntity(sessionInfo.request,new ZcMap() {{put("success", true);put("message", "message");}});
	}
	
	@SuppressWarnings("serial")
	@RequestMapping(path = "/login" , method = RequestMethod.POST)
	public ResponseEntity demoService(@RequestBody ZcMap reqData){
		ResponseEntity res=Validation.validateLogin(reqData, sessionInfo.request);
		if(res!=null) return res;
		ZcMap data=loginService.validateUser(reqData);
		if(Util.hasData(data)) sessionInfo.setSession(data);
		else return new ResponseEntity(sessionInfo.request,new ZcMap() {{put("success", false);put("message", "Invalid Credentials");}});
		return new ResponseEntity(sessionInfo.request,new ZcMap() {{put("success", true);put("data", data);put("message", "Login Successfully");}});
	}
}
