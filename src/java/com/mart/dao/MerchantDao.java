package com.mart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mart.model.Merchant;

@Repository
public class MerchantDao {
	private static final Logger log = Logger.getLogger(MerchantDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String query_add_merchant = "insert into t_merchants(C_MERCHANT_NAME,C_MOBILE,C_EMAIL,C_PASSWORD,C_ADDRESS,C_MERCHANT_PIC) values(?,?,?,?,?,?);" ;
	private static String query_add_shop = "insert into t_shops(C_SHOPNAME,C_LOCATION,C_ADDRESS,C_MERCHANT_ID,C_SHOP_PIC,C_DELEVERY_TYPE,C_OPENING_TIME,C_CLOSING_TIME,C_SHOPTYPE,C_MIN_ORDER_PRICE,C_DELIVERY_CHARGE) values(?,?,?,?,?,?,?,?,?,?,?);";
	private static String query_get_itemList = "select C_ITEM_ID,C_ITEMNAME,C_BRAND,C_ITEM_PIC from t_items ";
	

	public Merchant insertOrUpdate(final Merchant merchant) {
		Merchant result = null;
		log.info("IN ITEM DAO");
		log.info("merchant.getMerchantName():::"+merchant.getMerchantName());
		log.info("merchant.getPassword:::"+merchant.getPassword());
			try {
				KeyHolder keyHolder = new GeneratedKeyHolder();
				int i = jdbcTemplate.update(new InsertMerchant(merchant), keyHolder);
				System.out.println(keyHolder.getKey());
				String merchantId = keyHolder.getKey().toString();
				merchant.setMerchantId(merchantId);
				int j = jdbcTemplate.update(query_add_shop,
						new PreparedStatementSetter() {
							@Override
							public void setValues(PreparedStatement ps)
									throws SQLException {
								int index = 0;
								ps.setString(++index, merchant.getShopName());
								ps.setString(++index, merchant.getShopLocation());
								ps.setString(++index, merchant.getAddress());
								ps.setString(++index, merchant.getMerchantId());
								ps.setString(++index, merchant.getShopImage());
								ps.setString(++index, merchant.getDeliveryType());
								ps.setString(++index, merchant.getOpeningTime());
								ps.setString(++index, merchant.getClosingTime());
								ps.setString(++index, merchant.getShopType());
								ps.setString(++index, merchant.getMinOrderPrice());
								ps.setString(++index, merchant.getDeleveryCharges());
							}

						});
				
			} catch (Exception e) {
				result = new Merchant();
				//result.setStatus(false);
				e.printStackTrace();
				throw new RuntimeException();
			}

		
		return result;
	}
	
	
	
	/*public List<Item> getAllItems() {

		return (List<Item>) jdbcTemplate.query(query_get_itemList, new ResultSetExtractor<List<Item>>(){

			@Override
			public List<Item> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<Item> result= new ArrayList<Item>();
				while(rs.next()){
					Item item = new Item();
					item.setItemId(rs.getString("c_item_id"));
					item.setItemName(rs.getString("c_itemname"));
					item.setItemBrand(rs.getString("c_brand"));
					item.setItemImage(rs.getString("c_item_pic"));
					result.add(item);
				}
				log.info("ITEM:::"+result);
				return result;
			}
			
		});
	}
*/
static class InsertMerchant implements PreparedStatementCreator{
	Merchant merchant;
	
	public InsertMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection con)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(query_add_merchant);
		int index = 0;
		/*C_MERCHANT_NAME,C_MOBILE,C_EMAIL,C_PASSWORD,C_ADDRESS,C_MERCHANT_PIC*/
		pstmt.setString(++index, merchant.getMerchantName());
		pstmt.setString(++index, merchant.getMobile());
		pstmt.setString(++index, merchant.getMailid());
		pstmt.setString(++index, merchant.getPassword());
		pstmt.setString(++index, merchant.getAddress());
		pstmt.setString(++index, merchant.getMerchantImage());
		
		return pstmt;
	}
	
}
}

