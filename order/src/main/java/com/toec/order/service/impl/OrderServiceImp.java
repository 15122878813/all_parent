package com.toec.order.service.impl;

import com.toec.execption.ServiceExeception;
import com.toec.order.dao.OrderDao;
import com.toec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	@Override
	public int InsertToOrder(String user_name, String order_list) {
		
		if(order_list==null||order_list=="") {
			
			throw new ServiceExeception("请先选择菜品！");
			
		}
		
		return orderDao.InsertToOrder(user_name, order_list);
	}
	
	@Override
	public Map<String, Object> toFindAllSeat(String username) {
		return orderDao.toFindAllSeat(username);
	}

}
