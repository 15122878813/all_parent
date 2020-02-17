package com.toec.collection.service.impl;

import com.toec.collection.dao.CollectionDao;
import com.toec.execption.ServiceExeception;
import com.toec.pojo.Collection;
import com.toec.service.SysCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysCollectionServiceImp implements SysCollectionService {
	
	@Autowired
	private CollectionDao collectionDao;
	
	@Override
	public int toAddThisCollection(String collection_dish_name, Double collection_dish_money, String username) {
		
				return collectionDao.toAddThisCollection(collection_dish_name, collection_dish_money, username);
	}

	@Override
	public int toDeleteThisCollection(String collection_dish_name) {
		int deleteThisCollection = collectionDao.toDeleteThisCollection(collection_dish_name);
		if(deleteThisCollection==0) {
			throw new ServiceExeception("很抱歉！不存在该收藏！");
		}
		return deleteThisCollection;
	}

	@Override
	public List<Collection> doFindAllCollection(String userName) {
		if(null == userName){
			throw new ServiceExeception("非法异常");
		}
		List<Collection> list =
				collectionDao.doFindAllCollection(userName);
		return list;
	}

    @Override
    public Integer selectByName(String collection_dish_name) {
        return collectionDao.selectByName(collection_dish_name);
    }
}
