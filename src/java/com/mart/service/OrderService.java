package com.mart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mart.dao.OrderDao;
import com.mart.model.Order;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	public List<Order> getAllOrdersByShopId(String shopId) {
		return orderDao.getAllOrdersByShopId(shopId);
	}

	public List<Order> getCancelOrdersByShopId(String shopId) {
		return orderDao.getCancelOrdersByShopId(shopId);
	}

	public List<Order> getRejectedOrdersByShopId(String shopId) {
		return orderDao.getRejectedOrdersByShopId(shopId);
	}

	public List<Order> getPendingOrdersByShopId(String shopId) {
		return orderDao.getPendingOrdersByShopId(shopId);
	}

	public void dispatchOrder(String orderId) {
		orderDao.dispatchOrder(orderId);
	}
	public void rejectchOrder(String orderId) {
		orderDao.rejectOrder(orderId);
	}

	public List<Order> getDispatchedOrdersList(String shopId) {
		return orderDao.getDispatchedOrdersList(shopId);
	}
}
