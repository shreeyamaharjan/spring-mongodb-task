package com.shreeya.task1.membership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MembershipController {

	@Autowired
	private MembershipService membershipService;
	
	@GetMapping(value="/membership")
	public List<Membership> getMembership(){
		return membershipService.getAllMembership();
	}
	
	@GetMapping(value="/membership/{membershipId}")
	public Membership getMembershipById(@PathVariable String membershipId) {
		return membershipService.getMembership(membershipId);
	}
	
	@PostMapping(value="/membership/save")
	public String saveMembership(@RequestBody Membership membership) {
		membershipService.saveMembership(membership);
		return "Membership Added";
	}
	
	@PutMapping(value="/membership/update")
	public String updateMembership(@RequestBody Membership membership) {
		membershipService.updateMembership(membership);
		return "Updated";
	}
	
	@DeleteMapping(value="/membership/delete/{membershipId}")
	public String deleteMembership(@PathVariable String membershipId) {
		membershipService.deleteMembership(membershipId);
		return "Deleted";
	}
	
	@GetMapping(value="/memberships")
	public Page<Membership> fetchByPage(Pageable pageable){
		return membershipService.findByPage(pageable);
	}
}
