package com.mart.model;

public class Merchant {
	private String merchantId;
	private String merchantName;
	private String password;
	private String mailid;
	private String mobile;
	private String address;
	private String merchantImage;
	private String shopId;
	private String shopName;
	private String shopLocation;
	private String shopAddress;
	private String shopImage;
	private String deliveryType;
	private String openingTime;
	private String closingTime;
	private String shopType;
	


	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

		
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMerchantImage() {
		return merchantImage;
	}

	public void setMerchantImage(String merchantImage) {
		this.merchantImage = merchantImage;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLocation() {
		return shopLocation;
	}

	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopImage() {
		return shopImage;
	}

	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	@Override
	public String toString() {
		return "Merchant [address=" + address + ", closingTime=" + closingTime
				+ ", deliveryType=" + deliveryType + ", mailid=" + mailid
				+ ", merchantId=" + merchantId + ", merchantImage="
				+ merchantImage + ", merchantName=" + merchantName
				+ ", mobile=" + mobile + ", openingTime=" + openingTime
				+ ", password=" + password + ", shopAddress=" + shopAddress
				+ ", shopId=" + shopId + ", shopImage=" + shopImage
				+ ", shopLocation=" + shopLocation + ", shopName=" + shopName
				+ ", shopType=" + shopType + "]";
	}



	

}
