package com.shreeya.task1.membership;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MembershipRepository extends MongoRepository<Membership, String>,PagingAndSortingRepository<Membership, String> {

	Page<Membership> findAll(Pageable pageable);
}
