package com.shreeya.task1.purchase;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="purchasehistory")
public class purchaseHistory {

	@Id
	private String customerId;
	private String goodsId;
	private int quantity;
	
	public purchaseHistory() {
		super();
	}

	public purchaseHistory(String customerId, String goodsId, int quantity) {
		super();
		this.customerId = customerId;
		this.goodsId = goodsId;
		this.quantity = quantity;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public  String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "purchaseHistory [customerId=" + customerId + ", goodsId=" + goodsId + ", quantity=" + quantity + "]";
	}
}
