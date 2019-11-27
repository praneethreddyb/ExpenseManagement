package com.expense.core.base.controller;

import javax.servlet.http.HttpServletRequest;
import com.expense.core.bo.SessionInfo;

public class BaseController {

	public SessionInfo sessionInfo;
	
	public BaseController(HttpServletRequest request) {
		sessionInfo=new SessionInfo();
		sessionInfo.request=request;
	}
	
}
