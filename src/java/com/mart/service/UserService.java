package com.mart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mart.dao.UserDao;
import com.mart.model.Comment;
import com.mart.model.Customer;
import com.mart.model.Merchant;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public Customer save(Customer customer) {
		return userDao.insertOrUpdate(customer);
	}

	public Merchant isValidUser(Merchant merchant, String userType) {
		
		return userDao.isValidUser(merchant,userType);
	}

	public List<Merchant> getShops() {
		return userDao.getShops();
	}

	public Merchant getShopByMerchantId(String merchantId) {
		return userDao.getShopsByMerchantId(merchantId);
	}

	public List<Comment> getReviewsAndRatingsById(String shopId) {
		return userDao.getReviewsAndRatingsById(shopId);
	}

	public List<Customer> getCustomersByShopId(String shopId) {
		return userDao.getCustomersByShopId(shopId);
	}

}
