package com.mart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.mart.model.Customer;
import com.mart.model.Item;
import com.mart.model.Order;

@Repository
public class OrderDao {
	private static final Logger log = Logger.getLogger(OrderDao.class);
	private static final String query_to_get_all_orders_by_shopId ="SELECT o.c_order_id, c.*, i.*, oi.c_quantity, oi.c_total_price, o.c_orderd_time, o.c_status FROM t_customers c, t_items i, t_orders o, t_order_items oi, t_shop_items si WHERE o.c_customer_id=c.c_customer_id AND i.c_item_id=oi.c_item_id AND si.c_item_id=i.c_item_id AND oi.c_order_id = o.c_order_id AND si.c_shop_id = o.c_shop_id AND o.c_shop_id=? ";  
	private static final String query_dispatch_order ="update t_orders set c_status='Success',C_DISPATCH_TIME=now() where c_order_id=?";
	private static final String query_reject_order ="update t_orders set c_status='Rejected',C_DISPATCH_TIME=now() where c_order_id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Order> getAllOrdersByShopId(String shopId) {
		return jdbcTemplate.query(query_to_get_all_orders_by_shopId+"  and o.c_status!='Pending'", new String[]{shopId}, new OrdersResultSetExtractor());
	}
	
	public List<Order> getCancelOrdersByShopId(String shopId) {
		return jdbcTemplate.query(query_to_get_all_orders_by_shopId+"  and o.c_status='Canceled'", new String[]{shopId}, new OrdersResultSetExtractor());
	}

	public List<Order> getPendingOrdersByShopId(String shopId) {
		return jdbcTemplate.query(query_to_get_all_orders_by_shopId+"  and o.c_status='Pending'", new String[]{shopId}, new OrdersResultSetExtractor());
	}

	public List<Order> getRejectedOrdersByShopId(String shopId) {
		return jdbcTemplate.query(query_to_get_all_orders_by_shopId+"  and o.c_status='Rejected'", new String[]{shopId}, new OrdersResultSetExtractor());
	}

	static class OrdersResultSetExtractor implements ResultSetExtractor<List<Order>>{

		List<Order> orders = new ArrayList<Order>();
		@Override
		public List<Order> extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			Order old = null;
			Order o= new Order();
			boolean flag = true;
			double total = 0;
			while(rs.next()){
				
				if(old!=null && old.getOrderId()!=rs.getInt("c_order_id")){
					old.setTotalAmt(total);
					orders.add(old);
					total = 0;
				}
					
				if((o = getOrder(rs.getInt("c_order_id")))==null && ((old!=null && old.getOrderId()!=rs.getInt("c_order_id"))||flag)){
					flag = false;
					o = new Order();
					o.setOrderId(rs.getInt("c_order_id"));
					Customer c = new Customer();
					c.setCustomerId(rs.getString("C_CUSTOMER_ID"));
					c.setName(rs.getString("C_CUSTOMER_NAME"));
					c.setMobile(rs.getString("C_MOBILE"));
					c.setEmail(rs.getString("C_EMAIL"));
					c.setLocation(rs.getString("C_LOCATION"));
					c.setAddress(rs.getString("C_ADDRESS"));
					c.setMacid(rs.getString("C_MAC_ID"));
					c.setPic(rs.getString("C_CUSTOMER_PIC"));
					c.setFcmid(rs.getString("C_FCM_ID"));
					o.setCustomer(c);
					o.setOrderDate(rs.getString("c_orderd_time"));
					o.setStatus(rs.getString("c_status"));
					o.setItems(new ArrayList<Item>());
				}else{
					o = old;
				}
				Item i = new Item();
				i.setDescription(rs.getString("C_DESCRIPTION"));
				i.setItemBrand(rs.getString("C_BRAND"));
				i.setItemId(rs.getString("C_ITEM_ID"));
				i.setItemName(rs.getString("C_ITEMNAME"));
				i.setItemImage(rs.getString("C_ITEM_PIC"));
				i.setUnits(rs.getString("C_UNITS"));
				i.setQuantity(rs.getString("c_quantity"));
				i.setPrice(rs.getString("c_total_price"));
				try{
					total+= Integer.parseInt(i.getPrice());
				}catch(Exception e){
					
				}
				o.getItems().add(i);
				old = o;
			}
			old.setTotalAmt(total);
			orders.add(old);
			return orders;
		}

		private Order getOrder(int orderId) {
			for(Order o:orders){
				if(orderId == o.getOrderId()){
					return o;
				}
			}
			return null;
		}
		
	
	}

	public void dispatchOrder(String orderId) {
		jdbcTemplate.update(query_dispatch_order, orderId);
	}
	public void rejectOrder(String orderId) {
		jdbcTemplate.update(query_reject_order, orderId);
	}

	public List<Order> getDispatchedOrdersList(String shopId) {
		return jdbcTemplate.query(query_to_get_all_orders_by_shopId+"  and o.c_status='Success'", new String[]{shopId}, new OrdersResultSetExtractor());
	}
}
