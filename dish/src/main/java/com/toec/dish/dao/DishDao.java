package com.toec.dish.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DishDao {
	//查询所有的菜品
	@Select("select * from menu_caipin")
	List<Map<String,Object>> doFindAllDish();
	
	//查询所有对应菜系的菜品
	@Select("select * from menu_caipin where menu_id=#{id}")
	List<Map<String,Object>> doFindAllDishById(Integer id);
	
}
