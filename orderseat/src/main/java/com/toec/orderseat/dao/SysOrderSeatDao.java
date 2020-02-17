package com.toec.orderseat.dao;

import com.toec.pojo.OrderSeat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysOrderSeatDao {
	@Insert({"insert into order_seat values(null,"
			+ "#{orderseat_user_name},"
			+ "#{orderseat_time},"
			+ "#{orderseat_type},"
			+ "#{orderseat_date},"
			+ "#{orderseat_tel},"
			+ "#{orderseat_yonghuname},"
			+ "#{orderseat_gender},"
			+ "#{orderseat_number},"
			+ "#{orderseat_beizhu},"
			+ "#{status})"
			})
	int toOrederSeat(
            OrderSeat orderSeat
    );

	@Select("select * from order_seat where orderseat_user_name = #{cookieName}")
	Integer toFindAllCollection(String cookieName);
}