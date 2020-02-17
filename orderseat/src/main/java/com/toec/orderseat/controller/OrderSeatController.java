package com.toec.orderseat.controller;

import com.toec.common.vo.JsonResult;
import com.toec.execption.ServiceExeception;
import com.toec.pojo.OrderSeat;
import com.toec.service.SysOrderSeatService;
import com.toec.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class OrderSeatController {
	
	@Autowired
	private SysOrderSeatService sysOrderSeatService;
	
	//load进行跳转
	@RequestMapping("/dingZuoJiaZai")
	public String dodingZuoTiaoZhuan() {
		return "dzsure";
	}

	/*
	订座提交后，保存到表中
	 */
	@RequestMapping("/dingZuoTiJiao")
	@ResponseBody
	public JsonResult doDingZuoTiJiao(
			OrderSeat orderSeat
			, HttpServletRequest request) {
		String cookieName = CookieUtil.getCookieName(request);
		//1.先在收藏中进行查询
		Integer count = sysOrderSeatService.toFindAllCollection(cookieName);
		//2.再添加收藏
		if(count != null || count != 0){
			throw new ServiceExeception("您已经定座了，请不要再次进行提交！");
		}
		orderSeat.setOrderseatUserName(cookieName);
		orderSeat.setStatus(1);
		int orederSeat = sysOrderSeatService.toOrederSeat(
				orderSeat
				);
		System.out.println("这里将进行处理");
		return new JsonResult("您好，预订成功,请您按时到店就餐！");
	}
}
