package com.expense.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.core.dao.LoginDao;
import com.expense.core.util.ZcMap;

@Service(value = "loginService")
public class LoginService {

	@Autowired
	LoginDao loginDao;

	public ZcMap validateUser(ZcMap reqData) {
		return loginDao.validateUser(reqData.getS("userName"),reqData.getS("password"));
	}
}
