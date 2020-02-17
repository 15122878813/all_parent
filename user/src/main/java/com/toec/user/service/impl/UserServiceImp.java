package com.toec.user.service.impl;

import com.toec.execption.ServiceExeception;
import com.toec.pojo.UserPwd;
import com.toec.service.UserService;
import com.toec.user.dao.UserDao;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int SaveObject(UserPwd entity) {
		//合法验证
		if(entity.getUsername()==null || entity.getWx()==null || entity.getUsertel()==null || entity.getAddr()==null)
		throw new ServiceExeception("请填写全部的信息");
		int rows;
		try {
			rows = userDao.InsertNewUser(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceExeception("保存失败");
		}
		return rows;
	}
	@Override
	public int SavePassword(UserPwd entity) {
		String salt=UUID.randomUUID().toString();
		SimpleHash sh=new SimpleHash("MD5",entity.getPassword(),salt, 1);
		entity.setPassword(sh.toHex());
		entity.setSalt(salt);
		if(entity.getWx()==null || entity.getPassword()==null)
		throw new ServiceExeception("请填写全部信息");
		int rows;
		try {
			
			rows=userDao.InsertNewPwd(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceExeception("保存失败");
		}
		return rows;
	}
	@Override
	public UserPwd findPwdObjects(String username) {
		UserPwd findUserWXByUserName = userDao.findUserWXByUserName(username);
		
		if(findUserWXByUserName!=null) {
			throw new ServiceExeception("该账号已经存在，请重新进行注册！");
		}
		return findUserWXByUserName;
	}
}
