package com.shreeya.task1.goods;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GoodsRepository extends MongoRepository<Goods, String>,PagingAndSortingRepository<Goods, String>{



	@Query(value="{'goodsName':{$regex:?0,$options:'i'}}")
	Page<Goods> findByName(String goodsName,Pageable pageable);

	
}
