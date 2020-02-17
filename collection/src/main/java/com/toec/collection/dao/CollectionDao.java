package com.toec.collection.dao;

import com.toec.pojo.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectionDao {
	
	//用于添加收藏
	@Insert("insert into collection values("
			+ "null,"
			+ "#{collection_dish_name},"
			+ "#{collection_dish_money},"
			+ "#{username})")
	int toAddThisCollection(
            String collection_dish_name,
            Double collection_dish_money,
            String username);

	//用于删除收藏
	@Delete("delete from collection where "
			+ "collection_dish_name=#{collection_dish_name}")
	int toDeleteThisCollection(String collection_dish_name);

	//用于查询全部的收藏信息
	@Select("select * from collection where username= #{userName}")
	List<Collection> doFindAllCollection(String userName);

	@Select("select * from collection where collection_dish_name= #{collection_dish_name}")
    Integer selectByName(String collection_dish_name);
}