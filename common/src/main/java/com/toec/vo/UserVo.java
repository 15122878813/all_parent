package com.toec.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable{
 private static final long serialVersionUID = -4188622596222927158L;
 private Integer id;
 private String username;
 private String password; //md5
 /**盐值(加密盐-辅助加密,保证密码更加安全)*/
 private String salt;
 private String wx;
 private String userlevel; 
 private String userpoint;
 private Double usertcon;
 private String usertel;
 private String addr;
}