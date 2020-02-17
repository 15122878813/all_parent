package com.toec.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collection implements Serializable {

  private static final long serialVersionUID = 1592509316243740222L;
  private Long id;
  private String collectionDishName;
  private Double collectionDishMoney;
  private String username;
}
