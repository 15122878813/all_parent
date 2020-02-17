package com.toec.dish.controller;

import com.toec.common.vo.JsonResult;
import com.toec.service.SysDishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@Slf4j
public class DishController {
	
	@Autowired
	private SysDishService sysDishService;
	
	@RequestMapping("/doFindAllDish")
	@ResponseBody
	public JsonResult doFindAllDish() {
		List<Map<String, Object>> doFindAllDish = sysDishService.doFindAllDish();
		return new JsonResult(doFindAllDish);
	}

	//通过指定的菜类型，来显示对应的菜品
	@RequestMapping("/doFindAllDishById")
	@ResponseBody
	public JsonResult doFindAllDishById(Integer menu_id) {
		
		List<Map<String, Object>> doFindAllDishById = sysDishService.doFindAllDishById(menu_id);
		
		return new JsonResult(doFindAllDishById);
	}
}
