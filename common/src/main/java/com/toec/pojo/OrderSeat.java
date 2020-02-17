package com.toec.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSeat implements Serializable {
	private static final long serialVersionUID = -3201031541943846957L;
	private Integer id;
	private String orderseatUserName;
	private String orderseatTime;
	private String orderseatType;
	private String orderseatDate;
	private String orderseatTel;
	private String orderseatYonghuname;
	private String orderseatGender;
	private String orderseatNumber;
	private String orderseatBeizhu;
	private Integer status;
}