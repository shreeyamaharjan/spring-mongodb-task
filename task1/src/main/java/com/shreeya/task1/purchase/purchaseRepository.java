package com.shreeya.task1.purchase;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface purchaseRepository extends MongoRepository<purchaseHistory ,String> {

	List<purchaseHistory> getByGoodsId(String goodsId);
	List<purchaseHistory> getByCustomerId(String customerId);
	
}
