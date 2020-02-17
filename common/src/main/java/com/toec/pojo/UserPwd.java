package com.toec.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class UserPwd implements Serializable{
	private static final long serialVersionUID = -6617664886010317327L;


	private String username;
	private String wx;
	private String password; //md5
	/**盐值(加密盐-辅助加密,保证密码更加安全)*/
	private String salt;

	private String userlevel; 
	private String userpoint;
	private Double usertcon;
	private String usertel;
	private String addr;

	
	
	
}
