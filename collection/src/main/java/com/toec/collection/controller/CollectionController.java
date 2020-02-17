package com.toec.collection.controller;

import com.toec.common.vo.JsonResult;
import com.toec.execption.ServiceExeception;
import com.toec.pojo.Collection;
import com.toec.service.SysCollectionService;
import com.toec.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class CollectionController {
	
	@Autowired
	private SysCollectionService sysCollectionService;

	/*
		对页面中的收藏按钮进行添加
	 */
	@ResponseBody
	@RequestMapping("/toAddThisCollection")
	public JsonResult toAddThisCollection(
			String collection_dish_name,
			Double collection_dish_money,
			HttpServletRequest request) {
	    Integer count = sysCollectionService.selectByName(collection_dish_name);
	    if(count != null){
            throw new ServiceExeception("您已经收藏了该商品,请勿重新收藏");
        }
		int addThisCollection = sysCollectionService.toAddThisCollection(
				collection_dish_name, 
				collection_dish_money,
				CookieUtil.getCookieName(request));
		return new JsonResult("添加收藏成功");
	}
	/*
	将文件中的收藏按钮进行删除
	 */
	@RequestMapping("/toDeleteThisCollection")
	@ResponseBody
	public JsonResult toDeleteThisCollection(String menu_name) {
		int deleteThisCollection = sysCollectionService.toDeleteThisCollection(menu_name);
		return new JsonResult("恭喜您！取消收藏成功！");
	}

	/*
	对页面中的收藏按钮进行检验
	 */





	@RequestMapping("/doFindAllCollection")
	@ResponseBody
	public JsonResult doFindAllCollection(HttpServletRequest request){
		String userName = CookieUtil.getCookieName(request);
		List<Collection> list =
		sysCollectionService.doFindAllCollection(userName);
		return new JsonResult(list);
	}
}