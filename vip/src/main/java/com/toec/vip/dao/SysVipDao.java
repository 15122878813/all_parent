package com.toec.vip.dao;

import com.toec.pojo.OrderSeat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysVipDao {
	//根据用户名来查看用户的基本资料
	@Select("select * from user where user_wx = #{user_name}")
	Map<String, Object> doFindVipCenter(String user_name);
	
	//根据用户名来查看用户的订座信息
	@Select("select * from order_seat where orderseat_user_name=#{orderseat_user_name}")
	OrderSeat doFindOrderSeat(String orderseat_user_name);
	
	//根据用户名来查看用户的收藏菜品
	@Select("select * from collection where username=#{username}")
	List<Map<String,Object>> toFindAllCollection(String username);
}
