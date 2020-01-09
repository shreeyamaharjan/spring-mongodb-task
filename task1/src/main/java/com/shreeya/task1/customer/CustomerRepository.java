package com.shreeya.task1.customer;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository  extends MongoRepository<Customer, String> , PagingAndSortingRepository<Customer,String>{

	
	Page<Customer> findAll(Pageable pageable);
	
	//List<Customer> findByGoodsId(String goodsId);
	List<Customer> findByMembershipId(String membershipId);

	
}
