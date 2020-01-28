package com.shreeya.task1.productInfo;

import org.springframework.data.annotation.Id;

public class ProductInfo {

	@Id
	private String goodsId;
	private String manufacturer;
	private int manufactureCost; 
	
	public ProductInfo() {
		super();
	}
	public ProductInfo(String manufacturer, int manufactureCost) {
		super();
		this.manufacturer = manufacturer;
		this.manufactureCost = manufactureCost;	
	}

	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getManufactureCost() {
		return manufactureCost;
	}
	public void setManufactureCost(int manufactureCost) {
		this.manufactureCost = manufactureCost;
	}
	
	
	@Override
	public String toString() {
		return "ProductInfo [manufacturer=" + manufacturer + ", manufactureCost=" + manufactureCost + "]";
	}
	
}
