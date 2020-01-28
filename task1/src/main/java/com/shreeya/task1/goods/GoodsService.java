package com.shreeya.task1.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;


@Service
public class GoodsService {


	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public Page<Goods>findAllByPage(Pageable pageable){
		return goodsRepository.findAll(pageable);
	}
	
	public Goods saveGoods(Goods goods ) {
		return mongoTemplate.save(goods);
	}
	
	public List<Goods> getAllGoods(){
		return mongoTemplate.findAll(Goods.class);
	}
	
	public Goods findOneById(String goodsId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("goodsId").is(goodsId));
		return mongoTemplate.findOne(query, Goods.class);
	}
	
	public void deleteGoods(String goodsId) {
		Query query =new Query();
		query.addCriteria(Criteria.where("goodsId").is(goodsId));
		mongoTemplate.remove(query,Goods.class);
	}
	
	/*public Goods updateGoods(Goods goods) {
		return mongoTemplate.save(goods);
	}*/

	
	public UpdateResult updateGoods(Goods goods) {
		Query query=new Query();
		query.addCriteria(Criteria.where("goodsId").is(goods.getGoodsId()));
		
		
		Update update=new Update();
		update.set("goodsName",goods.getGoodsName());
		update.set("rate", goods.getRate());
		return mongoTemplate.updateFirst(query,update,Goods.class);
	}
	
	
	public List<Goods> findByRateRange(int lowerBound,int upperBound){
		Query query=new Query();
		query.addCriteria(Criteria.where("rate").gt(lowerBound)
		     .andOperator(Criteria.where("rate").lt(upperBound)));
		return mongoTemplate.find(query, Goods.class);
	}

	
}

