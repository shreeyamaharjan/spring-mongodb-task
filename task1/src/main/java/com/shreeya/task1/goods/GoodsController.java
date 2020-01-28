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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
    private GoodsService goodsService;
	
	@GetMapping("/paginate")
	public Page<Goods> fetchByPage(Pageable pageable){
		return goodsService.findAllByPage(pageable);
	}
	
	@GetMapping()
	public List<Goods> getAllGoods() {
		return goodsService.getAllGoods();
	}
	
	@PostMapping()
	public Goods createGoods(@RequestBody Goods goods) {
		return goodsService.saveGoods(goods);
	}
	@GetMapping("/{goodsId}")
	public Goods getGoodsById(@PathVariable String goodsId) {
		return goodsService.findOneById(goodsId);
	}
	
	@DeleteMapping("/{goodsId}")
	public void deleteGoods(@PathVariable String goodsId) {
		goodsService.deleteGoods(goodsId);
	}
	
	@PutMapping("/{goodsId}")
	public UpdateResult updateGoods(@RequestBody Goods goods) {
		return goodsService.updateGoods(goods);
	}
	
	@GetMapping("/range")
	public List<Goods> findByRate(@RequestParam Integer lowerBound,@RequestParam Integer upperBound){
		return goodsService.findByRateRange(lowerBound, upperBound);
	}

}
