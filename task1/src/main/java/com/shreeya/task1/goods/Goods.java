package com.shreeya.task1.goods;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shreeya.task1.productInfo.ProductInfo;

@Document(collection="Goods")
public class Goods {
	
	@Id
	private String goodsId;
	private String goodsName;
	private int rate;
	private List<ProductInfo> productInfo;
	
	public Goods() {
		super();
	}
	
	public Goods(String goodsId, String goodsName, int rate, List<ProductInfo> productInfo) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.rate = rate;
		this.productInfo = productInfo;
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
	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", rate=" + rate + ", productInfo="
				+ productInfo + "]";
	}
	
}
