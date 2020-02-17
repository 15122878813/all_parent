package com.toec.service;

import com.toec.pojo.UserPwd;

public interface UserService {

//	@Cacheable(value="findPwdObjects")
	UserPwd findPwdObjects(String username);
	
	int SaveObject(UserPwd entity);

	int SavePassword(UserPwd entity);
}
