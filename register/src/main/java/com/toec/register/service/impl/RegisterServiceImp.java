package com.toec.register.service.impl;


import java.util.UUID;

import com.toec.execption.ServiceExeception;
import com.toec.register.dao.RegisterDao;
import com.toec.service.RegisterService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp implements RegisterService {
	
	@Autowired
	private RegisterDao registerDao;
	@Override
	public int toAddUser(String user_name, String user_level, String user_point, Double user_total_consumption,
			String user_wx, String user_tel, String user_addr) {
		System.out.println(user_tel);
		if(!user_tel.matches("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$")) {
			throw new ServiceExeception("很抱歉，请您输入正确的手机号!");
		}
		int addUser = registerDao.toAddUser(user_name, user_level, user_point, user_total_consumption, user_wx, user_tel, user_addr);
		if(addUser==0) {
			throw new ServiceExeception("很抱歉！您注册失败！");
		}
		return addUser;
	}
	@Override
	public int toAddPwd(String wx, String password) {
		if(wx==null||wx=="") {
			throw new ServiceExeception("请输入您的微信账号！");
		}
		if(password==null||password=="") {
			throw new ServiceExeception("请输入您的密码！");
		}
		
		String salt = UUID.randomUUID().toString();
		SimpleHash sh = new SimpleHash("MD5", password, salt,1);
		password = sh.toHex();
		
		int addPwd = registerDao.toAddPwd(wx, password,salt);
		if(addPwd==0) {
			throw new ServiceExeception("很抱歉！注册失败！");
		}
		return addPwd;
	}
}
