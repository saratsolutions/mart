package com.mart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mart.dao.ItemDao;
import com.mart.model.Item;
import com.mart.model.ItemCategory;

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
	public List<ItemCategory> getItemCategories() {
		return itemDao.getItemCategories();
	}
	public void addItemCategory(ItemCategory category) {
		itemDao.addItemCategory(category);
	}
	public List<Item> getListOfItemsInShop(String shopId) {
		return itemDao.getListOfItemsInShop(shopId);
	}
	public List<Item> viewAllItemExceptShopId(String shopId) {
		return itemDao.getAllItemExceptShopId(shopId);
	}
	public void addItemToShop(Item item) {
		itemDao.addItemToShop(item);
	}
	public void updateShopItem(Item item) {
		itemDao.updateShopItem(item);
	}


}
