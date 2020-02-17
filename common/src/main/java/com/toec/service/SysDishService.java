package com.toec.service;

import java.util.List;
import java.util.Map;

public interface SysDishService {
	
//	@Cacheable(value="doFindAllDish")
	List<Map<String,Object>> doFindAllDish();
	
//	@Cacheable(value="doFindAllDishById")
	List<Map<String,Object>> doFindAllDishById(Integer id);
}
