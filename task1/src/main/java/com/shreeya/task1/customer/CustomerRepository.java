package com.shreeya.task1.customer;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository  extends MongoRepository<Customer, String> , PagingAndSortingRepository<Customer,String>{

	Page<Customer> findAll(Pageable pageable);
	List<Customer> findByMembershipId(String membershipId);

	@Query(value="{'name':{$regex:?0,$options:'i'}}")
	Page<Customer> findByName(String name,Pageable pageable);
	

}
