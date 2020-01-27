package com.shreeya.task1.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class purchaseController {

	@Autowired
	private purchaseService purchaseservice;
	
	@GetMapping()
	public List<purchaseHistory> getAllpurchases(){
		return purchaseservice.getAllpurchases();			
	}
	
	@PostMapping()
	public String addpurchase(@RequestBody purchaseHistory purchase) {
		purchaseservice.addpurchase(purchase);
		return "purchase Added";
	}
	
	@GetMapping(value="/custid")
	public List<purchaseHistory> getByCustomerId(@RequestParam String customerId) {
		return purchaseservice.getByCustomerId(customerId);
	}
	
	@GetMapping(value="/goodsid")
	public List<purchaseHistory> getByGoodsId(@RequestParam String goodsId) {
		return purchaseservice.getByGoodsId(goodsId);
	}
	
	@DeleteMapping(value="{goodsId}")
	public String deleteGoods(@PathVariable String goodsId){
		purchaseservice.deletepurchase(goodsId);
		return "Goods deleted";
	}
}
