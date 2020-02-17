package com.toec.service;

import com.toec.pojo.OrderSeat;

import java.util.List;
import java.util.Map;

public interface SysVipService {

//	@Cacheable(cacheNames = "doFindVipCenter")
	Map<String, Object> doFindVipCenter(String user_name);

//	@Cacheable(value="doFindOrderSeat")
	OrderSeat doFindOrderSeat(String orderseat_user_name);
	
//	@Cacheable(value="toFindAllCollection")
	List<Map<String,Object>> toFindAllCollection(String username);
}
