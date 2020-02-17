package com.shreeya.task1.membership;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembershipServiceTest {

	@InjectMocks
	private MembershipService service;
	
	@Mock
	private MembershipRepository repository;
	
	@Test
	public void testSaveMembership() {
		Membership membership = new Membership();
		membership.setMembershipId("M100");
		membership.setAnnualRate(800);
		membership.setMembershipType("Annual");
		
		Mockito.when(repository.save(membership)).thenReturn(membership);
		assertThat(service.saveMembership(membership)).isEqualTo(membership);
	}
	
	@Test
	public void testUpdateMembership() {
		Membership membership = new Membership();
		membership.setMembershipId("M100");
		membership.setAnnualRate(800);
		membership.setMembershipType("Annual");
		
		membership.setMembershipType("Gold");
		Mockito.when(repository.save(membership)).thenReturn(membership);
		assertThat(service.updateMembership(membership)).isEqualTo(membership);
	}
	
	@Test
	public void testDeleteMembership() {
		Membership membership = new Membership();
		membership.setMembershipId("M100");
		membership.setAnnualRate(800);
		membership.setMembershipType("Annual");
		
		Mockito.when(repository.existsById(membership.getMembershipId())).thenReturn(false);
		assertFalse(repository.existsById(membership.getMembershipId()));
	}
	
	@Test 
	public void testGetAllMembership() {
		Membership membership = new Membership();
		membership.setMembershipId("M100");
		membership.setAnnualRate(800);
		membership.setMembershipType("Annual");
		
		Membership membership1 = new Membership();
		membership1.setMembershipId("M105");
		membership1.setAnnualRate(900);
		membership1.setMembershipType("Golden");
		

		List<Membership>membershipList= new ArrayList<>();
		membershipList.add(membership);
		membershipList.add(membership1);
		
		Mockito.when(repository.findAll()).thenReturn(membershipList);
		assertThat(service.getAllMembership()).isEqualTo(membershipList);
	}

	//@Ignore
	@Test
	public void testGetMembership() {
		
		Membership membership= new Membership();
		membership.setAnnualRate(200);
		membership.setMembershipId("M001");
		membership.setMembershipType("Gold");
		Optional<Membership> member=Optional.of(membership);
		
		Mockito.when(repository.findById("M001")).thenReturn(member);
		assertThat(service.getMembership("M001")).isEqualTo(member);
	}
	
}
