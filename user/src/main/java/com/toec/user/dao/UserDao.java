package com.toec.user.dao;

import com.toec.pojo.UserPwd;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
	//此接口用于定义登录以及注册语句
	
	@Select("select * from pwd where wx=#{username}")
	UserPwd findUserWXByUserName(String username);
	
	@Insert("insert into user (user_name,user_wx,user_tel,user_addr) values (#{username},#{wx},#{usertel},#{addr})")
	int InsertNewUser(UserPwd entity);
	@Insert("insert into pwd (wx,password,salt) values (#{wx},#{password},#{salt})")
	int InsertNewPwd(UserPwd entity);
}
