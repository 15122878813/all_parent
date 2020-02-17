package com.toec.order.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface OrderDao {
	
	@Insert("insert into order_dingdan"
			+ " values(now(),#{user_name},"
			+ "#{order_list})")
	int InsertToOrder(String user_name,
                      String order_list);
	
	@Select("select * from order_seat where username = #{username}")
	Map<String,Object> toFindAllSeat(String username);
}
