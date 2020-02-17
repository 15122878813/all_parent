package com.toec.service;

public interface RegisterService {
	
	int toAddUser(String user_name,
                  String user_level,
                  String user_point,
                  Double user_total_consumption,
                  String user_wx,
                  String user_tel,
                  String user_addr);

	int toAddPwd(
            String wx,
            String password
    );
}
