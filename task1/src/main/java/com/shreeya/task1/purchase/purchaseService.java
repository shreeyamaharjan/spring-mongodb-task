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
	public List <purchaseHistory> getAllpurchases(){
		return purchaserepository.findAll();
		
	}
	
	public purchaseHistory addpurchase(purchaseHistory purchase) {
		
		 return purchaserepository.save(purchase);
	}
	
	public List<purchaseHistory> getByGoodsId(String goodsId){
		
		return this.purchaserepository.getByGoodsId(goodsId);
		
	}
	
	public List<purchaseHistory> getByCustomerId(String customerId){
		
		return this.purchaserepository.getByCustomerId(customerId);
		
	}
	
	public void deletepurchase(String goodsId) {
		purchaserepository.deleteById(goodsId);
	}
}
