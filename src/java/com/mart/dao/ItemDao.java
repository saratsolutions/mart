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
import com.mart.model.ItemCategory;

@Repository
public class ItemDao {
	private static final Logger log = Logger.getLogger(ItemDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static String query_add_item = "insert into t_items(C_ITEMNAME,C_BRAND,C_ITEM_PIC,C_UNITS,C_DESCRIPTION,C_CATEGORY_ID) values(?,?,?,?,?,?)";
	private static String query_get_itemList = "select C_ITEM_ID,C_ITEMNAME,C_BRAND,C_ITEM_PIC from t_items ";
	private static String getItemById = "select C_ITEM_ID,C_ITEMNAME,C_BRAND,C_ITEM_PIC,C_UNITS,C_DESCRIPTION from t_items where c_item_id=?";
	private static String query_get_item_categories = "select c_category_id as id,c_category_name as categoryName from t_categories";
	private static String query_add_item_category = "insert into t_categories(c_category_name) values(?)";
	private static String query_get_itemList_by_shopid = "select i.C_ITEM_ID,i.C_ITEMNAME,i.C_BRAND,i.C_ITEM_PIC,s.* from t_items i,t_shop_items s where s.c_item_id = i.c_item_id and s.c_shop_id=?";
	private static String query_get_itemList_except_shopId = "select i.C_ITEM_ID,i.C_ITEMNAME,i.C_BRAND,i.C_ITEM_PIC from t_items i where i.c_item_id not in (select i.C_ITEM_ID from t_items i,t_shop_items s where s.c_item_id = i.c_item_id and s.c_shop_id=?)";
	private static String query_add_item_to_shop = "insert into t_shop_items(c_shop_id,c_item_id,c_price,c_quantity,c_regular_units,c_medium_units,c_large_units,c_regular_units_price,c_medium_units_price,c_large_units_price) values(?,?,?,?,?,?,?,?,?,?)";
	private static String query_update_item_to_shop = "update t_shop_items set c_price=?,c_quantity=?,c_regular_units=?,c_medium_units=?,c_large_units=?,c_regular_units_price=?,c_medium_units_price=?,c_large_units_price=? where c_shop_id=? and c_item_id=?";

	public Item insertOrUpdate(final Item item) {
		Item result = null;
		log.info("IN ITEM DAO");
		log.info("item.getItemName():::" + item.getItemName());
		log.info("item.getItemBrand:::" + item.getItemBrand());
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
							ps.setString(++index,
									item.getUnits() != null ? item.getUnits()
											: "");
							ps.setString(++index,
									item.getDescription() != null ? item
											.getDescription() : "");
							ps.setString(++index, item.getItemCategoryId());
						}

					});

		} catch (Exception e) {
			result = new Item();
			// result.setStatus(false);
			e.printStackTrace();
			throw new RuntimeException();
		}

		return result;
	}

	public List<Item> getAllItems() {

		return (List<Item>) jdbcTemplate.query(query_get_itemList,
				new ResultSetExtractor<List<Item>>() {

					@Override
					public List<Item> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Item> result = new ArrayList<Item>();
						while (rs.next()) {
							Item item = new Item();
							item.setItemId(rs.getString("c_item_id"));
							item.setItemName(rs.getString("c_itemname"));
							item.setItemBrand(rs.getString("c_brand"));
							item.setItemImage(rs.getString("c_item_pic"));
							result.add(item);
						}
						log.info("ITEM:::" + result);
						return result;
					}

				});
	}

	public Item getItemById(String id) {
		return jdbcTemplate.queryForObject(getItemById, new Object[] { id },
				new RowMapper<Item>() {

					@Override
					public Item mapRow(ResultSet rs, int arg1)
							throws SQLException {
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

	public List<ItemCategory> getItemCategories() {
		return jdbcTemplate.query(query_get_item_categories,
				new ResultSetExtractor<List<ItemCategory>>() {

					@Override
					public List<ItemCategory> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<ItemCategory> itemCategories = new ArrayList<ItemCategory>();
						while (rs.next()) {
							ItemCategory cat = new ItemCategory();
							cat.setId(rs.getString("id"));
							cat.setCategoryName(rs.getString("categoryName"));
							itemCategories.add(cat);
						}
						return itemCategories;
					}

				});
	}

	public void addItemCategory(ItemCategory category) {
		jdbcTemplate.update(query_add_item_category, new String[] { category
				.getCategoryName() });
	}

	public List<Item> getListOfItemsInShop(String shopId) {
		return (List<Item>) jdbcTemplate.query(query_get_itemList_by_shopid,
				new String[] { shopId }, new ResultSetExtractor<List<Item>>() {

					@Override
					public List<Item> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Item> result = new ArrayList<Item>();
						while (rs.next()) {
							Item item = new Item();
							item.setItemId(rs.getString("c_item_id"));
							item.setItemName(rs.getString("c_itemname"));
							item.setItemBrand(rs.getString("c_brand"));
							item.setItemImage(rs.getString("c_item_pic"));
							item.setPrice(rs.getString("C_PRICE"));
							item.setQuantity(rs.getString("C_QUANTITY"));

							item.setRegularUnits(rs
									.getString("C_REGULAR_UNITS"));
							item.setRegularUnitsPrice(rs
									.getString("C_REGULAR_UNITS_PRICE"));
							item.setMediumUnits(rs.getString("C_MEDIUM_UNITS"));
							item.setMediumUnitsPrice(rs
									.getString("C_MEDIUM_UNITS_PRICE"));
							item.setLargeUnits(rs.getString("C_LARGE_UNITS"));
							item.setLargeUnitsPrice(rs
									.getString("C_LARGE_UNITS_PRICE"));

							result.add(item);
						}
						log.info("ITEM:::" + result);
						return result;
					}

				});
	}

	public List<Item> getAllItemExceptShopId(String shopId) {
		return (List<Item>) jdbcTemplate.query(
				query_get_itemList_except_shopId, new String[] { shopId },
				new ResultSetExtractor<List<Item>>() {

					@Override
					public List<Item> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						List<Item> result = new ArrayList<Item>();
						while (rs.next()) {
							Item item = new Item();
							item.setItemId(rs.getString("c_item_id"));
							item.setItemName(rs.getString("c_itemname"));
							item.setItemBrand(rs.getString("c_brand"));
							item.setItemImage(rs.getString("c_item_pic"));
							result.add(item);
						}
						log.info("ITEM:::" + result);
						return result;
					}

				});
	}

	public void addItemToShop(Item item) {
		jdbcTemplate.update(query_add_item_to_shop, new String[] {
				item.getShopId(), item.getItemId(), item.getPrice(), item.getQuantity(),
				item.getRegularUnits(),item.getMediumUnits(),item.getLargeUnits(),  
				item.getRegularUnitsPrice(),item.getMediumUnitsPrice(),item.getLargeUnitsPrice()});
	}

	public void updateShopItem(Item item) {

		jdbcTemplate
				.update(query_update_item_to_shop, new String[] {
						item.getPrice(), item.getQuantity(),
						item.getRegularUnits(),item.getMediumUnits(),item.getLargeUnits(),  
						item.getRegularUnitsPrice(),item.getMediumUnitsPrice(),item.getLargeUnitsPrice(),
						item.getShopId(), item.getItemId() });
	}
}
