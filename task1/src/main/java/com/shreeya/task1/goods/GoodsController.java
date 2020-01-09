package com.shreeya.task1.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
	
	@Autowired
    private GoodsService goodsService;
	
	@PostMapping(value="/goods/save")
	public String creategoods(@RequestBody Goods goods) {
		goodsService.addgoods(goods);
		return "goods created successfully ";
	}
	
	@GetMapping(value="/goods")
	public List<Goods> getGoods() {
		return goodsService.getAllGoods();
	}
	
	@GetMapping(value="/goods/{goodsId}")
	public Goods getGoodsById(@PathVariable String goodsId) {
		return goodsService.getGoods(goodsId);
	}
	
	@PutMapping(value="/goods/update")
	public void updateGoods(@RequestBody Goods goods) {
		goodsService.updategoods(goods);
	}
	
	@DeleteMapping(value="/goods/{goodsId}")
	public String deleteGoods(@PathVariable String goodsId){
		goodsService.deletegoods(goodsId);
		return "Goods deleted";
	}
	
	@GetMapping(value="/good")
	public Page<Goods> fetchByPage(Pageable pageable){
		return goodsService.findAllByPage(pageable);
	}

}
