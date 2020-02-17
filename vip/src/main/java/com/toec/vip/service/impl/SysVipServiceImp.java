package com.toec.vip.service.impl;

import com.toec.common.annotation.CacheGet;
import com.toec.execption.ServiceExeception;
import com.toec.pojo.OrderSeat;
import com.toec.service.SysVipService;
import com.toec.vip.dao.SysVipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysVipServiceImp implements SysVipService {
	
	@Autowired
	private SysVipDao sysVipDao;

	@Override
//	@CacheGet(seconds = 20,key = "doFindVipCenter")
	public Map<String, Object> doFindVipCenter(String user_name) {
		if(user_name == null || user_name == "") {
			throw new ServiceExeception("您还没有登录，请进行登录！");
		}
//		user_name = "15222083907";
		return sysVipDao.doFindVipCenter(user_name);
	}
	@Override
	@CacheGet(seconds = 20,key = "doFindOrderSeat")
	public OrderSeat doFindOrderSeat(String orderseat_user_name) {
		
		if(orderseat_user_name==null 
				|| 
				orderseat_user_name=="") {
			throw new ServiceExeception("您还没有登录，请进行登录！");
		}
		return sysVipDao.doFindOrderSeat(orderseat_user_name);
	}

	@Override
	@CacheGet(seconds = 20,key = "toFindAllCollection")
	public List<Map<String,Object>> toFindAllCollection(String username) {
		
		List<Map<String,Object>> findAllCollection = sysVipDao.toFindAllCollection(username);
		
		return findAllCollection;
	}
}
