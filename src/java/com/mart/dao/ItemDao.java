package com.mart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mart.model.Item;

@Repository
public class ItemDao {
	private static final Logger log = Logger.getLogger(ItemDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String query_add_item = "insert into t_items(C_ITEMNAME,C_BRAND,C_ITEM_PIC,C_UNITS,C_DESCRIPTION) values(?,?,?,?,?)";
	private static String query_get_itemList = "select C_ITEM_ID,C_ITEMNAME,C_BRAND,C_ITEM_PIC from t_items ";
	private static String getItemById = "select C_ITEM_ID,C_ITEMNAME,C_BRAND,C_ITEM_PIC,C_UNITS,C_DESCRIPTION from t_items where c_item_id=?";
	

	public Item insertOrUpdate(final Item item) {
		Item result = null;
		log.info("IN ITEM DAO");
		log.info("item.getItemName():::"+item.getItemName());
		log.info("item.getItemBrand:::"+item.getItemBrand());
			try {
				
				int i = jdbcTemplate.update(query_add_item,
						new PreparedStatementSetter() {

							@Override
							public void setValues(PreparedStatement ps)
									throws SQLException {
								int index = 0;
								ps.setString(++index, item.getItemName());
								ps.setString(++index, item.getItemBrand());
								ps.setString(++index, item.getItemImage());
								ps.setString(++index, item.getUnits()!=null?item.getUnits():"");
								ps.setString(++index, item.getDescription()!=null?item.getDescription():"");
							}

						});
				
			} catch (Exception e) {
				result = new Item();
				//result.setStatus(false);
				e.printStackTrace();
				throw new RuntimeException();
			}

		
		return result;
	}
	
	
	
	public List<Item> getAllItems() {

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


	public Item getItemById(String id) {
		return jdbcTemplate.queryForObject(getItemById, new Object[]{id}, new RowMapper<Item>(){

			@Override
			public Item mapRow(ResultSet rs, int arg1) throws SQLException {
				Item item = new Item();
				item.setItemId(rs.getString("c_item_id"));
				item.setItemName(rs.getString("c_itemname"));
				item.setItemBrand(rs.getString("c_brand"));
				item.setItemImage(rs.getString("c_item_pic"));
				item.setUnits(rs.getString("c_units"));
				item.setDescription(rs.getString("C_DESCRIPTION"));
				return item;
			}
		});
	}

	
}
