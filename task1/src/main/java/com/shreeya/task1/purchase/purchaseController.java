package com.shreeya.task1.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class purchaseController {

	@Autowired
	private purchaseService purchaseservice;
	
	@GetMapping(value="/purchase")
	public List<purchaseHistory> getAllPurchases(){
		return purchaseservice.getAllPurchases();			
	}
	
	@PostMapping(value="/purchase")
	public String addPurchase(@RequestBody purchaseHistory purchase) {
		purchaseservice.addPurchase(purchase);
		return "Purchase Added";
	}
	
	@GetMapping(value="/custid")
	public List<purchaseHistory> getByCustomerId(@RequestParam String customerId) {
		return purchaseservice.getByCustomerId(customerId);
	}
	
	@GetMapping(value="/goodsid")
	public List<purchaseHistory> getByGoodsId(@RequestParam String goodsId) {
		return purchaseservice.getByGoodsId(goodsId);
	}
}
