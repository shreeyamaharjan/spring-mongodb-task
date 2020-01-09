package com.shreeya.task1.goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class GoodsService {


	@Autowired
	private GoodsRepository goodsRepository;
	
	public List<Goods> getAllGoods(){
		List<Goods> goods=new ArrayList<>();
		goodsRepository.findAll().forEach(goods::add);
		return goods;
	}
	
	public Goods getGoods(String goodsId) {
		 Optional<Goods> good=goodsRepository.findById(goodsId) ;
		 if(good.isPresent()){
			 	return good.get();
		 	}
		 return null;
	}
	
	public void addgoods(Goods goods) {
		goodsRepository.save(goods);
	}
	
	public void updategoods(Goods goods) {
		goodsRepository.save(goods);
	}
	
	public void deletegoods(String goodsId) {
		goodsRepository.deleteById(goodsId);
	}

	public Page<Goods>findAllByPage(Pageable pageable){
		return goodsRepository.findAll(pageable);
	}
	
}

