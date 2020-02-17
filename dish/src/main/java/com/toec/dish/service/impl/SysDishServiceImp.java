package com.toec.dish.service.impl;

import com.toec.dish.dao.DishDao;
import com.toec.execption.ServiceExeception;
import com.toec.service.SysDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysDishServiceImp implements SysDishService {
	
	@Autowired
	private DishDao dishDao;
	
	@Override
	public List<Map<String,Object>> doFindAllDish() {
		
		List<Map<String, Object>> doFindAllDish = dishDao.doFindAllDish();
		
		if(doFindAllDish.size()==0) {
			
			throw new ServiceExeception("现在还没有菜品，请您敬请期待");
			
		}
		
		return doFindAllDish;
	}

	@Override
	public List<Map<String, Object>> doFindAllDishById(Integer id) {
		
		return dishDao.doFindAllDishById(id);
		
	}
}
