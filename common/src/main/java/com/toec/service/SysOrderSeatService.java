package com.toec.service;

import com.toec.pojo.OrderSeat;

public interface SysOrderSeatService {
	
	int toOrederSeat(
            OrderSeat orderSeat
    );

    Integer toFindAllCollection(String cookieName);
}
