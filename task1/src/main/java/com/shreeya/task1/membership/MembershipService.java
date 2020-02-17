package com.shreeya.task1.membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MembershipService {

	@Autowired
	private MembershipRepository membershipRepository;
	
	List<Membership> memberships=new ArrayList<>();
	public List<Membership> getAllMembership(){
		membershipRepository.findAll().forEach(memberships::add);
		return memberships;
	}
	
	public Membership getMembership(String membershipId) {
		Optional<Membership> membership=membershipRepository.findById(membershipId);
		if(membership.isPresent()) {
			return membership.get();
		}
		return null;
	}
	
	public  Membership saveMembership(Membership membership) {
		return membershipRepository.save(membership);
	}
	
	public Membership updateMembership(Membership membership) {
		return membershipRepository.save(membership);
	}
	
	public void deleteMembership(String membershipId) {
		membershipRepository.deleteById(membershipId);
	}
	
	public Page<Membership> findByPage(Pageable pageable){
		return membershipRepository.findAll(pageable);
	}
}
