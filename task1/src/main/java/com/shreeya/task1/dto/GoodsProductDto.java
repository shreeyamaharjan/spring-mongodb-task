package com.shreeya.task1.dto;

import org.springframework.data.annotation.Id;



public class GoodsProductDto {

	@Id
	private String goodsId;
	private String goodsName;
	private int rate;
	
	private String id;
	private String manufacturer;
	private int manufactureCost;
	
	public GoodsProductDto(String goodsId, String goodsName, int rate, String id, String manufacturer,
			int manufactureCost) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.rate = rate;
		this.id = id;
		this.manufacturer = manufacturer;
		this.manufactureCost = manufactureCost;
	}

	public GoodsProductDto() {
		super();
	
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "GoodsProductDto [goodsId=" + goodsId + ", goodsName=" + goodsName + ", rate=" + rate + ", id=" + id
				+ ", manufacturer=" + manufacturer + ", manufactureCost=" + manufactureCost + "]";
	}
}
