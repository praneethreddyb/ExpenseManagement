package com.expense.core.validations;

import javax.servlet.http.HttpServletRequest;

import com.expense.core.response.entity.ResponseEntity;
import com.expense.core.util.ZcMap;

public class Validation {

	@SuppressWarnings("serial")
	public static ResponseEntity validateLogin(ZcMap reqData,HttpServletRequest request) {
		if(reqData.isBlank("userName") || reqData.isBlank("password")) {
			return new ResponseEntity(request, new ZcMap() {{put("success", false);put("message", "Mandatory Fields Missing");}});
		}else {
			return null;
		}
	}
}
