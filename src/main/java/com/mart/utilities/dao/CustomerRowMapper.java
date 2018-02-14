package com.mart.utilities.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mart.model.Customer;

public class CustomerRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		Customer customer = null;
		try {
			customer = new Customer();
			customer.setCustomerId(rs.getString("C_CUSTOMER_ID"));
			customer.setName(rs.getString("C_CUSTOMER_NAME"));
			customer.setEmail(rs.getString("C_MOBILE"));
			customer.setPassword(rs.getString("C_EMAIL"));
			customer.setLocation(rs.getString("C_LOCATION"));
			customer.setAddress(rs.getString("C_ADDRESS"));
			customer.setMacid(rs.getString("C_MAC_ID"));
			customer.setFcmid(rs.getString("C_FCM_ID"));
			customer.setStatus(customer.getCustomerId() != null);
		} catch (Exception e) {
			customer = null;
		}
		return customer;
	}

}
