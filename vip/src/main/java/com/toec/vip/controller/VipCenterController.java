package com.toec.vip.controller;

import com.toec.common.vo.JsonResult;
import com.toec.pojo.OrderSeat;
import com.toec.service.SysVipService;
import com.toec.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Random;

//load-vip-center/findVipCenter
@Controller
@RequestMapping("/")
@Slf4j
public class VipCenterController {

	@Autowired
	private SysVipService sysVipService;
	/*
	会员中心左上角 以及 中间内容展示
	 */
	@RequestMapping("/doFindVipCenter")
	@ResponseBody
	public JsonResult doFindVipCenter(HttpServletRequest request,String userName) throws InterruptedException {
//		String cookieName = CookieUtil.getCookieName(request);
//		int s = new Random().nextInt(2000);
//		System.out.println(s);
//		Thread.sleep(2000);
		Map<String, Object> doFindVipCenter = sysVipService.doFindVipCenter(userName);
		log.error("11111");
		return new JsonResult(doFindVipCenter);
	}
	/*
	在会员中心里的我的订座的显示
	 */
	@RequestMapping("/doFindDingZuo")
	@ResponseBody
	public JsonResult doFindOrderSeat(HttpServletRequest request) {
//		CookieUtil.getCookieName(request);
		OrderSeat doFindOrderSeat = sysVipService.doFindOrderSeat("15222083907");
		return new JsonResult(doFindOrderSeat);
	}
	/*
	在会员中心里的我的收藏的显示
	 */
	@RequestMapping("/toFindAllCollection")
	@ResponseBody
	public JsonResult toFindAllCollection(HttpServletRequest request) {
//		CookieUtil.getCookieName(request);
		List<Map<String, Object>> findAllCollection = sysVipService.toFindAllCollection("15222083907");
		return new JsonResult(findAllCollection);
	}
}