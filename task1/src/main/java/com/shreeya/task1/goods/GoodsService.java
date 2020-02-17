package com.shreeya.task1.goods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.shreeya.task1.dto.GoodsProductDto;
import com.shreeya.task1.productInfo.ProductInfo;


@Service
public class GoodsService {


	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Page<Goods>findAllByPage(int page,int size,String goodsName,Sort.Direction sortDirection, String sortBy){
		return goodsRepository.findByName(goodsName,PageRequest.of(page, size, sortDirection, sortBy));
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

	public Goods updateGoods(Goods goods) {
		Query query=new Query();
		query.addCriteria(Criteria.where("goodsId").is(goods.getGoodsId()));
		Update update=new Update();
		update.set("goodsName", goods.getGoodsName());
		update.set("rate", goods.getRate());
		return mongoTemplate.findAndModify(query, update, Goods.class);
	}
	
	public GoodsProductDto updateProductInfo(GoodsProductDto gpDto,String id) {
		Query query=new Query();
		query.addCriteria(Criteria.where("id").is(gpDto.getId()).andOperator(Criteria.where("goodsId").is(gpDto.getGoodsId())));
		Update update=new Update();
		update.set("manufacturer", gpDto.getManufacturer());
		update.set("manufactureCost",gpDto.getManufactureCost());
		return mongoTemplate.findAndModify(query, update, GoodsProductDto.class);
		
	}
	
	
	public List<Goods> findByRateRange(int lowerBound,int upperBound){
		Query query=new Query();
		query.addCriteria(Criteria.where("rate").gt(lowerBound)
		     .andOperator(Criteria.where("rate").lt(upperBound)));
		return mongoTemplate.find(query, Goods.class);
	}

	public Goods addProductInfo(String goodsId,GoodsProductDto gpDto) throws Exception {
		Goods goods=this.findOneById(goodsId);
		
		if(goods==null) {
			throw new Exception("Goods Not Found");
		}
		
		System.out.println(" Before adding p info" );
		ProductInfo productI=new ProductInfo();
		productI.setManufactureCost(gpDto.getManufactureCost());
		productI.setManufacturer(gpDto.getManufacturer());
		
		System.out.println(" p i "+productI);
		//below null case is only necessary if you havent initialized the 
		if(goods.getProductInfo()!=null && !goods.getProductInfo().isEmpty()) {
			goods.getProductInfo().add(productI);
		}else {
			List<ProductInfo> productInfo=new ArrayList<>();
			productInfo.add(productI);
			goods.setProductInfo(productInfo);
		}
		
		return this.mongoTemplate.save(goods);
	}

	/*public GoodsProductDto findProductById(String id, GoodsProductDto gpDto) {
		Query query=new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, GoodsProductDto.class);
	}*/

	}

