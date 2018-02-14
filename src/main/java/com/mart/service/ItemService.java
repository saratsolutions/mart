package com.mart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mart.dao.ItemDao;
import com.mart.dao.UserDao;
import com.mart.model.Customer;
import com.mart.model.Item;
import com.mart.model.Merchant;

@Service
public class ItemService {
	@Autowired
	private ItemDao itemDao;
	
	public Item addItem(Item item) {
		System.out.println("IN ADD ITEM MTHD");
		
		return itemDao.insertOrUpdate(item);
	}
	public List<Item> viewAllItem() {
		System.out.println("IN viewAllItem MTHD");
		
		return itemDao.getAllItems();
	}
	public Item getItemById(String id) {
		return itemDao.getItemById(id);
	}


}
