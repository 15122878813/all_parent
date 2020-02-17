package com.toec.order.controller;

import com.toec.common.vo.JsonResult;
import com.toec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//订单的controller
	@RequestMapping("toInsertIntoEnd")
	@ResponseBody
	public JsonResult InsertToOrder(String user_name, String order_list) {
		orderService.InsertToOrder(user_name, order_list);
		return new JsonResult("订单确认成功!");
	}
	
	@RequestMapping("/toFindAllSeat")
	@ResponseBody
	public JsonResult toFindAllSeat(String username) {
		Map<String, Object> findAllSeat = orderService.toFindAllSeat(username);
		return new JsonResult(findAllSeat);
	}
}
