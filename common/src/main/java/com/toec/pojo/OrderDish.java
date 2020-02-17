package com.toec.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class OrderDish implements Serializable {
	private static final long serialVersionUID = -6134069681443991183L;
	private Integer id;
	private String menu_name;
	private Double menu_money;
	private String menu_info;
	private Integer menu_id;
}
