package com.mart.model;

public class ItemCategory {
	private String id;
	private String categoryName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "ItemCategory [categoryName=" + categoryName + ", id=" + id
				+ "]";
	}

}
