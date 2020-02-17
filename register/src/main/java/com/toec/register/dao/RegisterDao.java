package com.toec.register.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterDao {
	
	//1.添加用户信息
	@Insert("insert into user values(null,"
			+ "#{user_name},#{user_level},#{user_point},"
			+ "#{user_total_consumption},#{user_wx},#{user_tel},"
			+ "#{user_addr})")
	int toAddUser(String user_name,
			     String user_level,
			     String user_point,
			     Double user_total_consumption,
			     String user_wx,
			     String user_tel,
			     String user_addr);
	//2.添加密码信息
	@Insert("insert into pwd values(null,#{wx},#{password},#{salt})")
	int toAddPwd(
			String wx,
			String password,
			String salt
			);
}
