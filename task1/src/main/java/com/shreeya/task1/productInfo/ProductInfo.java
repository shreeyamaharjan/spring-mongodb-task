package com.shreeya.task1.productInfo;

import org.springframework.data.annotation.Id;

import com.shreeya.task1.utility.UuidGenerator;

public class ProductInfo {

	@Id
	private String id;
	private String manufacturer;
	private int manufactureCost; 
	
	public ProductInfo() {
		super();
		this.id=UuidGenerator.getUuid();
	}
	

	public ProductInfo(String id, String manufacturer, int manufactureCost) {
		super();
		this.id = id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", manufacturer=" + manufacturer + ", manufactureCost=" + manufactureCost
				+ "]";
	}
}
