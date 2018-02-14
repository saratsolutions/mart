package com.mart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mart.model.Comment;
import com.mart.model.Customer;
import com.mart.model.Item;
import com.mart.model.Merchant;
import com.mart.utilities.dao.CustomerRowMapper;

@Repository
public class UserDao {
	private static final Logger log = Logger.getLogger(UserDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static String query_admin_user_by_username_and_password = "select count(*) from t_adminusers where ( c_email = ? or c_mobile = ?)and c_password = ?";
	private static String query_get_customer = "select * from t_customers where ";
	private static String query_add_customer = "insert into t_customers(c_customer_name,c_mobile,c_email,c_password,c_location,c_address,c_mac_id,c_fcm_id) values(?,?,?,?,?,?,?,?)";
	private static String query_get_shops = "select s.c_shop_id,s.c_shopname,s.c_location,s.c_address,s.c_shop_pic,s.c_delevery_type,s.c_opening_time,s.c_closing_time,s.c_shoptype,m.c_merchant_id,m.c_merchant_name,m.c_mobile,m.c_email,m.c_address as shopaddress,m.c_merchant_pic from t_shops s,t_merchants m where s.c_merchant_id=m.c_merchant_id";
	private static String query_get_shops_by_id = query_get_shops
			+ " and m.c_merchant_id = ?";
	private static String query_merchant_by_username_and_password = query_get_shops
			+ " and ( c_email = ? or c_mobile = ?) and c_password = ?";
	private static String query_ratings_and_reviews = "select c.*,r.c_rating,r.c_desc,r.C_COMMENTD_DATE from t_ratings r,t_customers c where c.c_customer_id=r.c_customer_id and r.c_shop_id=?";
	private static String query_Customers_from_shopId ="select c.*,count(*) as count from t_customers c,t_orders o where c.c_customer_id = o.c_customer_id and o.c_shop_id=? group by c_customer_name order by count desc";
	public Customer insertOrUpdate(final Customer customer) {
		Customer result = null;
		try {
			result = getCustomer(customer.getCustomerId(), "c_mac_id");
			if (result != null) {
				log.info("update query");
			}
		} catch (EmptyResultDataAccessException erde) {
			try {
				int i = jdbcTemplate.update(query_add_customer,
						new PreparedStatementSetter() {

							@Override
							public void setValues(PreparedStatement ps)
									throws SQLException {
								int index = 0;
								ps.setString(++index, customer.getName());
								ps.setString(++index, customer.getMobile());
								ps.setString(++index, customer.getEmail());
								ps.setString(++index, customer.getPassword());
								ps.setString(++index, customer.getLocation());
								ps.setString(++index, customer.getAddress());
								ps.setString(++index, customer.getMacid());
								ps.setString(++index, customer.getFcmid());
							}

						});
				if (i == 1) {
					result = getCustomer(customer.getCustomerId(), "c_mac_id");
				} else {
					throw new Exception("unable to insert record");
				}
			} catch (Exception e) {
				result = new Customer();
				result.setStatus(false);
				e.printStackTrace();
			}

		} catch (Exception e) {
			result = new Customer();
			result.setStatus(false);
			e.printStackTrace();
		}
		return result;
	}

	private Customer getCustomer(String input, String column) {

		return (Customer)jdbcTemplate.queryForObject(query_get_customer + column + "=?",
				new Object[] { input }, new CustomerRowMapper());
	}

	public Merchant isValidUser(Merchant merchant, String userType) {
		try {
			if (userType.equalsIgnoreCase("ADMIN")) {
				int val = jdbcTemplate.queryForObject(
						query_admin_user_by_username_and_password,
						Integer.class, new Object[] { merchant.getMerchantId(),
								merchant.getMerchantId(),
								merchant.getPassword() });
				if (val == 1)
					return merchant;
			} else if (userType.equalsIgnoreCase("MERCHANT")) {
				Merchant m = jdbcTemplate.queryForObject(
						query_merchant_by_username_and_password, new String[] {
								merchant.getMerchantId(),
								merchant.getMerchantId(),
								merchant.getPassword() },
						new RowMapper<Merchant>() {

							@Override
							public Merchant mapRow(ResultSet rs, int rowNum)
									throws SQLException {
								Merchant merchant = new Merchant();
								merchant.setShopId(rs.getString("c_shop_id"));
								merchant
										.setShopName(rs.getString("c_shopname"));
								// merchant.set(rs.getString("c_location"));
								merchant.setShopAddress(rs
										.getString("c_address"));
								merchant.setShopImage(rs
										.getString("c_shop_pic"));
								merchant.setDeliveryType(rs
										.getString("c_delevery_type"));
								merchant.setOpeningTime(rs
										.getString("c_opening_time"));
								merchant.setClosingTime(rs
										.getString("c_closing_time"));
								merchant
										.setShopType(rs.getString("c_shoptype"));
								merchant.setMerchantId(rs
										.getString("c_merchant_id"));
								merchant.setMerchantName(rs
										.getString("c_merchant_name"));
								merchant.setMobile(rs.getString("c_mobile"));
								merchant.setMailid(rs.getString("c_email"));
								merchant
										.setAddress(rs.getString("shopaddress"));
								merchant.setMerchantImage(rs
										.getString("c_merchant_pic"));

								return merchant;
							}

						});
				return m;
			} else {
				throw new RuntimeException("Invalid usertype");
			}
		} catch (Exception e) {
			log.info("User Not Found" + e.getMessage());
		}
		return null;
	}

	public List<Merchant> getShops() {

		return (List<Merchant>) jdbcTemplate.query(query_get_shops,
				new ResultSetExtractor<List<Merchant>>() {

					@Override
					public List<Merchant> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Merchant> result = new ArrayList<Merchant>();
						while (rs.next()) {
							Merchant merchant = new Merchant();
							merchant.setShopId(rs.getString("c_shop_id"));
							merchant.setShopName(rs.getString("c_shopname"));
							// merchant.set(rs.getString("c_location"));
							merchant.setShopAddress(rs.getString("c_address"));
							merchant.setShopImage(rs.getString("c_shop_pic"));
							merchant.setDeliveryType(rs
									.getString("c_delevery_type"));
							merchant.setOpeningTime(rs
									.getString("c_opening_time"));
							merchant.setClosingTime(rs
									.getString("c_closing_time"));
							merchant.setShopType(rs.getString("c_shoptype"));
							merchant.setMerchantId(rs
									.getString("c_merchant_id"));
							merchant.setMerchantName(rs
									.getString("c_merchant_name"));
							merchant.setMobile(rs.getString("c_mobile"));
							merchant.setMailid(rs.getString("c_email"));
							merchant.setAddress(rs.getString("shopaddress"));
							merchant.setMerchantImage(rs
									.getString("c_merchant_pic"));
							result.add(merchant);
						}
						log.info("getShops () :::" + result);
						return result;
					}

				});

	}

	public Merchant getShopsByMerchantId(String merchantId) {
		System.out.println(query_get_shops_by_id);
		return jdbcTemplate.queryForObject(query_get_shops_by_id,
				new String[] { merchantId.trim() }, new RowMapper<Merchant>() {

					@Override
					public Merchant mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Merchant merchant = new Merchant();
						merchant.setShopId(rs.getString("c_shop_id"));
						merchant.setShopName(rs.getString("c_shopname"));
						// merchant.set(rs.getString("c_location"));
						merchant.setShopAddress(rs.getString("c_address"));
						merchant.setShopImage(rs.getString("c_shop_pic"));
						merchant.setDeliveryType(rs
								.getString("c_delevery_type"));
						merchant.setOpeningTime(rs.getString("c_opening_time"));
						merchant.setClosingTime(rs.getString("c_closing_time"));
						merchant.setShopType(rs.getString("c_shoptype"));
						merchant.setMerchantId(rs.getString("c_merchant_id"));
						merchant.setMerchantName(rs
								.getString("c_merchant_name"));
						merchant.setMobile(rs.getString("c_mobile"));
						merchant.setMailid(rs.getString("c_email"));
						merchant.setAddress(rs.getString("shopaddress"));
						merchant.setMerchantImage(rs
								.getString("c_merchant_pic"));

						return merchant;
					}

				});
	}

	public List<Comment> getReviewsAndRatingsById(String shopId) {

		return (List<Comment>) jdbcTemplate.query(query_ratings_and_reviews,
				new String[] { shopId },
				new ResultSetExtractor<List<Comment>>() {

					@Override
					public List<Comment> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Comment> result = new ArrayList<Comment>();
						while (rs.next()) {
							Comment comment = new Comment();
							Customer cust = new Customer();
							cust.setCustomerId(rs.getString("C_CUSTOMER_ID"));
							cust.setName(rs.getString("C_CUSTOMER_NAME"));
							cust.setMobile(rs.getString("C_MOBILE"));
							cust.setEmail(rs.getString("C_EMAIL"));
							cust.setLocation(rs.getString("C_LOCATION"));
							cust.setAddress(rs.getString("C_ADDRESS"));
							cust.setMacid(rs.getString("C_MAC_ID"));
							cust.setPic(rs.getString("C_CUSTOMER_PIC"));
							comment.setCustomer(cust);
							comment.setRating(rs.getInt("c_rating"));
							comment.setComment(rs.getString("c_desc"));
							comment.setCommentedDate(rs
									.getString("C_COMMENTD_DATE"));
							result.add(comment);
						}
						log.info("comments () :::" + result);
						return result;
					}

				});

	}

	public List<Customer> getCustomersByShopId(String shopId) {
		return (List<Customer>) jdbcTemplate.query(query_Customers_from_shopId,
				new String[] { shopId },
				new ResultSetExtractor<List<Customer>>() {

					@Override
					public List<Customer> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Customer> result = new ArrayList<Customer>();
						while (rs.next()) {
							Customer c = new Customer();
							c.setCustomerId(rs.getString("c_customer_id"));
							c.setName(rs.getString("C_CUSTOMER_NAME"));
							c.setMobile(rs.getString("C_MOBILE"));
							c.setEmail(rs.getString("C_EMAIL"));
							c.setLocation(rs.getString("C_LOCATION"));
							c.setAddress(rs.getString("C_ADDRESS"));
							c.setMacid(rs.getString("C_MAC_ID"));
							c.setPic(rs.getString("C_CUSTOMER_PIC"));
							c.setFcmid(rs.getString("C_FCM_ID"));
							result.add(c);
						}
						log.info("customers () :::" + result);
						return result;
					}

				});
	}
}
