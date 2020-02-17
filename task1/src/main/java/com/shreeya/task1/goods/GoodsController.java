package com.shreeya.task1.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shreeya.task1.dto.GoodsProductDto;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
    private GoodsService goodsService;
	
	@GetMapping("/paginate")
	public Page<Goods> fetchByPage(
			@RequestParam(value="page",defaultValue = "0")int page,
			@RequestParam(value="size",defaultValue = "2")int size,
			@RequestParam(value="sort",defaultValue = "ASC")Sort.Direction sort,
			@RequestParam(value="sortBy",defaultValue = "goodsName") String sortBy,
			@RequestParam(value="goodsName",defaultValue = "",required=false) String goodsName
			){
		return goodsService.findAllByPage(page,size,goodsName,sort,sortBy);
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
	public Goods updateGoods(@RequestBody Goods goods,@PathVariable String goodsId) {
		goods.setGoodsId(goodsId);
		goodsService.updateGoods(goods);
		return goods;
	}
	
	@GetMapping("/range")
	public List<Goods> findByRate(@RequestParam Integer lowerBound,@RequestParam Integer upperBound){
		return goodsService.findByRateRange(lowerBound, upperBound);
	}

	@PostMapping("/{goodsId}/productInfo")
	public Goods addProductInfo(@RequestBody GoodsProductDto gpDto, @PathVariable(value ="goodsId") String goodsId) throws Exception {
		return goodsService.addProductInfo(goodsId, gpDto);
	}
	
	/*@GetMapping("/{goodsId}/productInfo/{id}")
	public GoodsProductDto getProduct(@RequestBody GoodsProductDto gpDto,@PathVariable (value="id")String id) {
		return goodsService.findProductById(id,gpDto);
	}*/
	//post and put,delete method   using path variable id and request body goods
	
	@PutMapping("/{goodsId}/productInfo/{id}")
	public GoodsProductDto updateProductInfo(@RequestBody GoodsProductDto gpDto,@PathVariable("id")String id) {
		
		
		goodsService.updateProductInfo( gpDto, id);
		return gpDto;
	}
	
	
}


