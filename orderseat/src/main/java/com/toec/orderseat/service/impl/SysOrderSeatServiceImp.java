package com.toec.orderseat.service.impl;

import com.toec.execption.ServiceExeception;
import com.toec.orderseat.dao.SysOrderSeatDao;
import com.toec.pojo.OrderSeat;
import com.toec.service.SysOrderSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysOrderSeatServiceImp implements SysOrderSeatService {
	
	@Autowired
	private SysOrderSeatDao sysOrderSeatDao;
	
	public int toOrederSeat(
			OrderSeat orderSeat
			) {
		if(orderSeat.getOrderseatNumber()==null
				||orderSeat.getOrderseatUserName()==null
				) {
			throw new ServiceExeception("很抱歉。请您填入必要的信息，这对我们来说是很重要的！");
		}
		if(!orderSeat.getOrderseatTel().matches("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$")) {
			throw new ServiceExeception("很抱歉，请您输入正确的手机号!");
		}
		if(!orderSeat.getOrderseatNumber().matches("^\\d+$|^\\d+[.]?\\d+$")) {
			throw new ServiceExeception("很抱歉，请您输入正确的数量格式!");
		}
		int rows = sysOrderSeatDao.toOrederSeat(
				orderSeat);
		System.out.println(orderSeat);
		if(rows==0) {
			throw new ServiceExeception("很抱歉！添加座位失败");
		}
		return rows;
	}

	@Override
	public Integer toFindAllCollection(String cookieName) {
		return sysOrderSeatDao.toFindAllCollection(cookieName);
	}
}
