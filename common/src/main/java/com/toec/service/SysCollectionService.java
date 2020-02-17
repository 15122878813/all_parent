package com.toec.service;

import com.toec.pojo.Collection;

import java.util.List;

public interface SysCollectionService {
	
	int toAddThisCollection(
            String collection_dish_name,
            Double collection_dish_money,
            String username);
	
	int toDeleteThisCollection(String collection_dish_name);

    List<Collection> doFindAllCollection(String userName);

    Integer selectByName(String collection_dish_name);
}
