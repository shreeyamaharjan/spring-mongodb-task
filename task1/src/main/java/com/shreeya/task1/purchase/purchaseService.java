package com.shreeya.task1.purchase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class purchaseService {

	@Autowired
	private purchaseRepository purchaserepository;

	List<purchaseHistory> purchase=new ArrayList<>();
	public List <purchaseHistory> getAllPurchases(){
		return purchaserepository.findAll();
		
	}
	
	public purchaseHistory addPurchase(purchaseHistory purchase) {
		
		 return purchaserepository.save(purchase);
	}
	
	public List<purchaseHistory> getByGoodsId(String goodsId){
		List<purchaseHistory>history=new ArrayList<>();
		history=this.purchaserepository.getByGoodsId(goodsId);
		return history;
	}
	
	public List<purchaseHistory> getByCustomerId(String customerId){
		List<purchaseHistory>history=new ArrayList<>();
		history=this.purchaserepository.getByCustomerId(customerId);
		return history;
	}
	
	
}
