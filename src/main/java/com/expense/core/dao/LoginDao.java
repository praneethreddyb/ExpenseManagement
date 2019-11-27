package com.expense.core.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.expense.core.util.ZcMap;

@Repository(value = "loginDao")
public class LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public ZcMap validateUser(String userName, String password) {
		String query="SELECT * FROM user WHERE (login_id=? OR mobile_no=? OR email=?) AND password=?";
		ZcMap data=new ZcMap();
		try {
			Map<String, Object> _x=jdbcTemplate.queryForMap(query,userName,userName,userName,password);
			data=new ZcMap(_x);
		}catch (Exception e) {e.printStackTrace();}
		return data;
	}
}
