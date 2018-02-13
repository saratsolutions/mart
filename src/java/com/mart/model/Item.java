package com.mart.model;

public class Item {
	private String itemId;
	private String itemName;
	private String itemBrand;
	private String itemImage;
	private String units;
	private String description;
	private String quantity;
	private String price;
	private String itemCategoryId;
	private String regularUnits;
	private String regularUnitsPrice;
	private String mediumUnits;
	private String mediumUnitsPrice;
	private String largeUnits;
	private String largeUnitsPrice;
	private String shopId;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(String itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public String getRegularUnits() {
		return regularUnits;
	}

	public void setRegularUnits(String regularUnits) {
		this.regularUnits = regularUnits;
	}

	public String getRegularUnitsPrice() {
		return regularUnitsPrice;
	}

	public void setRegularUnitsPrice(String regularUnitsPrice) {
		this.regularUnitsPrice = regularUnitsPrice;
	}

	public String getMediumUnits() {
		return mediumUnits;
	}

	public void setMediumUnits(String mediumUnits) {
		this.mediumUnits = mediumUnits;
	}

	public String getMediumUnitsPrice() {
		return mediumUnitsPrice;
	}

	public void setMediumUnitsPrice(String mediumUnitsPrice) {
		this.mediumUnitsPrice = mediumUnitsPrice;
	}

	public String getLargeUnits() {
		return largeUnits;
	}

	public void setLargeUnits(String largeUnits) {
		this.largeUnits = largeUnits;
	}

	public String getLargeUnitsPrice() {
		return largeUnitsPrice;
	}

	public void setLargeUnitsPrice(String largeUnitsPrice) {
		this.largeUnitsPrice = largeUnitsPrice;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Item [description=" + description + ", itemBrand=" + itemBrand
				+ ", itemCategoryId=" + itemCategoryId + ", itemId=" + itemId
				+ ", itemImage=" + itemImage + ", itemName=" + itemName
				+ ", largeUnits=" + largeUnits + ", largeUnitsPrice="
				+ largeUnitsPrice + ", mediumUnits=" + mediumUnits
				+ ", mediumUnitsPrice=" + mediumUnitsPrice + ", price=" + price
				+ ", quantity=" + quantity + ", regularUnits=" + regularUnits
				+ ", regularUnitsPrice=" + regularUnitsPrice + ", shopId="
				+ shopId + ", units=" + units + "]";
	}

}
