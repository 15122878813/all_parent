package com.toec.register.controller;

import com.toec.common.vo.JsonResult;
import com.toec.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/toAddUser")
	@ResponseBody
	public JsonResult toAddUser(
			 String user_name,
		     String user_level,
		     String user_point,
		     Double user_total_consumption,
		     String user_wx,
		     String user_tel,
		     String user_addr) {
		int addUser = registerService.toAddUser
				(user_name, user_level, user_point, 
				user_total_consumption, user_wx, user_tel, user_addr);
		return new JsonResult();
		
	};
	
	@RequestMapping("/toAddPwd")
	@ResponseBody
	public JsonResult toAddPwd(
			String wx,
			String password
			) {
		int addPwd = registerService.toAddPwd(wx, password);
		return new JsonResult();
	}
}