package com.mart.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mart.dao.ItemDao;
import com.mart.dao.MerchantDao;
import com.mart.dao.UserDao;
import com.mart.model.Customer;
import com.mart.model.Item;
import com.mart.model.Merchant;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao merchantDao;
	
	public Merchant addShop(Merchant merchant) {
		System.out.println("IN ADD ITEM MTHD");
		
		return merchantDao.insertOrUpdate(merchant);
	}
	


}
