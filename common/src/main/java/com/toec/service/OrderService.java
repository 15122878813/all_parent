package com.toec.service;

import java.util.Map;

public interface OrderService {
	
	int InsertToOrder(String user_name,
                      String order_list);
	Map<String,Object> toFindAllSeat(String username);
}
